import au.com.ausstaker.snet.server.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import au.com.ausstaker.cage.EfusionListener;
import au.com.ausstaker.cage.EfusionProcessManager;
import au.com.ausstaker.cage.compute.ComputeResults;
import util.ObservationTestHelpers;
import util.TestAsset;
import util.TestTarget;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author edge2ipi (https://github.com/Ausstaker)
 */
public class SnetClientTests implements EfusionListener {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(SnetClientTests.class);

    private ManagedChannel channel;
    private ServiceDefinitionGrpc.ServiceDefinitionBlockingStub blockingStub;

    TestAsset asset_a = new TestAsset();
    TestAsset asset_b = new TestAsset();
    TestAsset asset_c = new TestAsset();
    TestAsset asset_d = new TestAsset();

    /* Some common asset coords to reuse */
    double[] asset_a_coords = new double[]{-31.9, 115.98};
    double[] asset_b_coords = new double[]{-31.88, 115.97};
    double[] asset_c_coords = new double[]{-31.78, 115.90};
    double[] asset_d_coords = new double[]{-32.0, 115.85};

    TestTarget target_a = new TestTarget();

    /* Protobuf Target */
    Target target;

    EfusionProcessManager efusionProcessManager = new EfusionProcessManager(this);
    double range_rand_factor = 200; // = 0; /* Guide: 50 [m] */
    double tdoa_rand_factor = 0.0000001; // = 0.0000001; /* Guide: 0.0000001 [sec] */
    double aoa_rand_factor = 0.1; // = 0; /* Guide: 0.1 [radians] */

    @Override
    public void result(ComputeResults computeResults) {
        log.debug("Result Received at Test Class: "+"Result -> GeoId: "+computeResults.getGeoId()+", Lat: "+computeResults.getGeolocationResult().getLat()+", Lon: "+computeResults.getGeolocationResult().getLon()+", CEP major: "+computeResults.getGeolocationResult().getElp_long()+", CEP minor: "+computeResults.getGeolocationResult().getElp_short()+", CEP rotation: "+computeResults.getGeolocationResult().getElp_rot());
        log.warn("WARNING, not adding to results buffer in Process Manager REVISIT LATER");
        //this.resultBuffer.put(target_id, new GeoResult(geoId,target_id,lat,lon,cep_elp_maj,cep_elp_min,cep_elp_rot));
    }

    @Before
    public void configure() {
        int service_port=7070;
        this.channel = ManagedChannelBuilder.forAddress("localhost", service_port).usePlaintext().build();
        System.out.println("Client connected on port: " + String.valueOf(service_port));
        this.blockingStub = ServiceDefinitionGrpc.newBlockingStub(channel);

        /* App specific configs */
        //simulatedTargetObserver.setEfusionProcessManager(efusionProcessManager);

        target_a.setId("A");
        target_a.setName("Target A");
        target_a.setTrue_lat(-31.9); // BOTTOM
        target_a.setTrue_lon(116.000);
        target_a.setLat_move(0.0); // STATIC
        target_a.setLon_move(0.0);

        /* Define and add the Protobuf Target definition */
        target = Target.newBuilder()
                .setId(target_a.getId())
                .setName(target_a.getName())
                .setTrueLat(target_a.getTrue_lat())
                .setTrueLon(target_a.getTrue_lon()).build();

        /* Reusable test assets */
        asset_a.setId("A");
        asset_a.setProvide_range(true);
        asset_a.setProvide_tdoa(false); // tdoa not implemented in NAV
        asset_a.setProvide_aoa(true);
        asset_a.setCurrent_loc(asset_a_coords);

        asset_b.setId("B");
        asset_b.setProvide_range(true);
        asset_b.setProvide_tdoa(false);
        asset_b.setProvide_aoa(true);
        asset_b.setCurrent_loc(asset_b_coords);

        asset_c.setId("C");
        asset_c.setProvide_range(true);
        asset_c.setProvide_tdoa(false);
        asset_c.setProvide_aoa(true);
        asset_c.setCurrent_loc(asset_c_coords);

        asset_d.setId("D");
        asset_d.setProvide_range(true);
        asset_d.setProvide_tdoa(false);
        asset_d.setProvide_aoa(true);
        asset_d.setCurrent_loc(asset_d_coords);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    @Test
    public void testBottom_FourAssets() {
        try {
            /* Targets to be tracked by filter, specified by client */
            log.debug(target_a.getId());

            /* Targets for the sim observer to report data on */
            Map<String, TestTarget> testTargets = new HashMap<String, TestTarget>()
            {{
                put(target_a.getId(), target_a);
            }};

            /* Assets to measure observations to/from */
            Map<String, TestAsset> assets = new HashMap<String, TestAsset>()
            {{
                put(asset_a.getId(), asset_a);
                put(asset_b.getId(), asset_b);
                put(asset_c.getId(), asset_c);
                put(asset_d.getId(), asset_d);
            }};

            GeoRequest.Builder geoRequestBuilder = GeoRequest.newBuilder();

            /* Generate and add some observations */
            List<Observation> observations = ObservationTestHelpers.generateSetOfObservations(testTargets,assets,range_rand_factor,tdoa_rand_factor,aoa_rand_factor);
            log.debug("Number of observations added for this test: "+observations.size());
            for (Observation observation : observations) {
                log.info(observation.toString());
                geoRequestBuilder.addObservation(observation);
            }

            /* Add the target */
            geoRequestBuilder.setTarget(target);
            /* TODO, could consider adding the full GeoMission POJO configs */
            GeoRequest geoRequest = geoRequestBuilder.build();
            GeolocationResult response;

            try {
                /* Call Remote procedure */
                response = blockingStub.geoFixMe(geoRequest);
                log.info("Result: \n" + response.toString());
            } catch (StatusRuntimeException e) {
                log.warn( "RPC failed: {0}", e.getStatus());
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }catch (Exception e) {
            System.out.println("Unknown error running test");
            e.printStackTrace();
        }
    }
}
