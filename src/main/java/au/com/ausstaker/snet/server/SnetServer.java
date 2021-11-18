package au.com.ausstaker.snet.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import au.com.ausstaker.cage.EfusionListener;
import au.com.ausstaker.cage.EfusionProcessManager;
import au.com.ausstaker.cage.compute.ComputeResults;
import au.com.ausstaker.cage.model.GeoMission;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import au.com.ausstaker.cage.model.MissionMode;
import au.com.ausstaker.cage.model.ObservationType;
import au.com.ausstaker.cage.model.Target;
import au.com.ausstaker.cage.util.ConfigurationException;
import au.com.ausstaker.snet.util.KmlFileStaticHelpers;
import au.com.ausstaker.snet.util.RequestValidationException;
import au.com.ausstaker.snet.util.Status;
import static java.util.Objects.isNull;

/**
 * @author edge2ipi (https://github.com/Ausstaker)
 */
public class SnetServer {

    private static final Logger log = LoggerFactory.getLogger(SnetServer.class.getName());

    private Server server;

    private void start() throws IOException {
        int port = 7070;
        server = ServerBuilder.forPort(port)
                .addService(new ServiceDefinitionImpl())
                .build()
                .start();
        log.info("Server listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                SnetServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final SnetServer server = new SnetServer();
        server.start();
        server.blockUntilShutdown();
    }

    //SERVICE_API
    static class ServiceDefinitionImpl extends ServiceDefinitionGrpc.ServiceDefinitionImplBase implements EfusionListener {

        GeoMission geoMission;
        EfusionProcessManager cageProcessManager = new EfusionProcessManager(this);

        @Override
        public void result(ComputeResults computeResults) {
            log.debug("[Progress Result]: "+computeResults.toString());
        }

        @Override
        public void geoFixMe(GeoRequest request, StreamObserver<GeolocationResult> responseObserver) {
            log.debug("Received new request: "+request);
            GeolocationResult geolocationResult;
            try {
                Status status = validateRequest(request);
                log.debug("Request status: "+status.getType()+": "+status.getFriendlyType());
                if (status!=Status.OK) {
                    throw new RequestValidationException(status);
                }

                // 0. Set up the compute library with configs
                geoMission = new GeoMission();
                geoMission.setMissionMode(MissionMode.fix);
                geoMission.setGeoId("MY_GEO_ID");
                geoMission.setShowMeas(true);
                geoMission.setShowCEPs(true);
                geoMission.setShowGEOs(true);
                geoMission.setOutputKml(false);
                geoMission.setOutputKmlFilename("geoOutput.kml");
                geoMission.setShowTrueLoc(false);
                geoMission.setOutputFilterState(false);
                geoMission.setOutputFilterStateKmlFilename("filterState.kml");
                log.debug("GeoMission: "+geoMission.toString());

                Target target = new Target();
                target.setId(request.getTarget().getId());
                target.setName(request.getTarget().getName());
                target.setTrue_current_loc(new Double[]{request.getTarget().getTrueLat(),request.getTarget().getTrueLon()}); // For engineering & performance measurement only
                log.debug("Target: "+target.toString());

                cageProcessManager.configure(geoMission);
                cageProcessManager.reconfigureTarget(target);
                log.debug("Configured Geo Mission, continuing");

                // 1. Take in measurements from the request: List<Obs> Obs
                List<Observation> observations = request.getObservationList();
                for (Observation obs : observations) {
                    /* Convert request data to format compatible with CAGE */
                    au.com.ausstaker.cage.model.Observation cageObservation = new au.com.ausstaker.cage.model.Observation(
                            obs.getId(),
                            obs.getAssetId(),
                            obs.getLat(),
                            obs.getLon());
                    cageObservation.setMeas(obs.getMeas());
                    cageObservation.setObservationType(ObservationType.valueOf(obs.getType()));
                    cageObservation.setTargetId(request.getTarget().getId());

                    try {
                        cageProcessManager.addObservation(cageObservation);
                    } catch (Exception e) {
                        log.error("Couldn't add observation: " + obs.toString()+":: "+e.getMessage());
                        e.printStackTrace();
                    }
                }

                // 2. Compute the fused result
                ComputeResults computeResults = cageProcessManager.start();
                log.debug("[Final Compute Result]: "+computeResults.toString());

                String kml_out="";
                if (request.getProvideKmlOut()) {
                    log.debug("option selected to generate kml");
                    kml_out = KmlFileStaticHelpers.exportGeoMissionToKml(geoMission);
                }

                if (isNull(computeResults.getGeolocationResult().getStatus_message())) {
                    computeResults.getGeolocationResult().setStatus_message("");
                }

                /* FORMAT RESULT FOR SNET / PROTOBUF Purposes */
                GeolocationResult.Builder builder = GeolocationResult.newBuilder()
                        .setLat(computeResults.getGeolocationResult().getLat())
                        .setLon(computeResults.getGeolocationResult().getLon())
                        .setElpLong(computeResults.getGeolocationResult().getElp_long())
                        .setElpShort(computeResults.getGeolocationResult().getElp_short())
                        .setElpRot(computeResults.getGeolocationResult().getElp_rot())
                        .setResidual(computeResults.getGeolocationResult().getResidual())
                        .setStatus(computeResults.getGeolocationResult().getStatus().name())
                        .setStatusMessage(computeResults.getGeolocationResult().getStatus_message())
                        .setKmlOutput(kml_out);
                geolocationResult = builder.build();
            }
            catch (RequestValidationException rve) {
                log.debug("Error with request, returning. Error: "+rve.getStatus().getFriendlyType());
                rve.printStackTrace();
                GeolocationResult.Builder builder = GeolocationResult.newBuilder()
                        .setStatus(rve.getStatus().getType())
                        .setStatusMessage(rve.getStatus().getFriendlyType());
                geolocationResult = builder.build();
            }
            catch (ConfigurationException ce) {
                log.error("Error trying to configure mission, returning. Error: "+ce.getMessage());
                ce.printStackTrace();
                GeolocationResult.Builder builder = GeolocationResult.newBuilder()
                        .setStatus(Status.MISSION_CONFIG_ERROR.getType());
                geolocationResult = builder.build();
            }
            catch (IOException ioe) {
                log.error("IO Error trying to configure mission, returning. Error: "+ioe.getMessage());
                ioe.printStackTrace();
                GeolocationResult.Builder builder = GeolocationResult.newBuilder()
                        .setStatus(Status.MISSION_CONFIG_ERROR.getType());
                geolocationResult = builder.build();
            }
            catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
                log.error("Unknown Error in computation, returning");
                GeolocationResult.Builder builder = GeolocationResult.newBuilder()
                        .setStatus(Status.UNKNOWN.getType())
                        .setStatusMessage("UNKNOWN Error: "+e.toString());
                geolocationResult = builder.build();
            }

            //Return to client
            log.debug("Generated result: \n"+geolocationResult);
            log.info("Processed request with: "+request.getObservationList().size()+" observations. Status: "+geolocationResult.getStatus());
            responseObserver.onNext(geolocationResult);
            responseObserver.onCompleted();
        }

        public Status validateRequest(GeoRequest geoRequest) {
            if (geoRequest.getTarget()==null) {
                return Status.NO_TARGET_DESCRIPTION;
            }
            if (geoRequest.getObservationList()==null) {
                return Status.NO_OBSERVATIONS;
            }
            if (geoRequest.getObservationList().size()<2) {
                return Status.NOT_ENOUGH_OBSERVATIONS;
            }
            List<Observation> observationList = geoRequest.getObservationList();
            for (Observation obs : observationList) {
                if (isNull(obs.getId()) ||
                        isNull(obs.getLat()) ||
                        isNull(obs.getLon()) ||
                        isNull(obs.getAssetId()) || obs.getAssetId().isEmpty() ||
                        isNull(obs.getMeas()) ||
                        isNull(obs.getType()) || obs.getType().isEmpty()) {
                    return Status.OBSERVATION_ILL_FORMED;
                }
            }
            return Status.OK;
        }
    }
}
