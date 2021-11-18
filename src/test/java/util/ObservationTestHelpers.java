package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import au.com.ausstaker.cage.model.ObservationType;
import au.com.ausstaker.cage.util.Helpers;
import au.com.ausstaker.snet.server.Observation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author edge2ipi (https://github.com/Ausstaker)
 */
public class ObservationTestHelpers {

    private static final Logger log = LoggerFactory.getLogger(ObservationTestHelpers.class);

    public static double getRangeMeasurement(double a_y, double a_x, double true_y, double true_x, double range_rand_factor) {
        return Math.sqrt(Math.pow(a_y-true_y,2) + Math.pow(a_x-true_x,2)) + (Math.random()-0.5)*range_rand_factor;
    }

    public static double getTdoaMeasurement(double a_y, double a_x, double b_y, double b_x, double true_y, double true_x, double tdoa_rand_factor) {
        return (Math.sqrt(Math.pow(a_y-true_y,2) + Math.pow(a_x-true_x,2))
                - Math.sqrt(Math.pow(b_y-true_y,2) + Math.pow(b_x-true_x,2)))/ Helpers.SPEED_OF_LIGHT
                + (Math.random()-0.5)*tdoa_rand_factor;
    }

    public static double getAoaMeasurement(double a_y, double a_x, double true_y, double true_x, double aoa_rand_factor) {
        double meas_aoa = Math.atan((a_y-true_y)/(a_x-true_x)) + (Math.random()-0.5)*aoa_rand_factor;
        log.debug("Meas AOA: "+meas_aoa);

        if (true_x < a_x) {
            meas_aoa = meas_aoa + Math.PI;
        }
        if (true_y<a_y && true_x>=a_x) {
            meas_aoa = (Math.PI- Math.abs(meas_aoa)) + Math.PI;
        }
        log.debug("Meas AOA (adjusted): "+meas_aoa);
        return meas_aoa;
    }

    public static List<Observation> generateSetOfObservations(Map<String,TestTarget> testTargets, Map<String,TestAsset> testAssets,
                                                              double range_rand_factor, double tdoa_rand_factor, double aoa_rand_factor) {

        List<Observation> observations = new ArrayList<Observation>();

        // 1. FOR EACH testTarget, go through all assets and see which ones to generate a measurement to (NOT FROM!)
        for (TestTarget testTarget :testTargets.values()) {
            log.debug("Generating new observations for target: "+testTarget.getId());

            double[] utm_coords = Helpers.convertLatLngToUtmNthingEasting(testTarget.getTrue_lat(), testTarget.getTrue_lon());
            double true_y = utm_coords[0]; /// TRUE (SIM) LOCATION OF MY TARGET - i.e. THE PLATFORM TO ESTIMATE
            double true_x = utm_coords[1];

            /* for each asset, generate relevant observations */
            log.debug("Regenerating observations from # assets: " + testAssets.keySet().size());
            for (TestAsset asset : testAssets.values()) {
                utm_coords = Helpers.convertLatLngToUtmNthingEasting(asset.getCurrent_loc()[0], asset.getCurrent_loc()[1]);
                double asset_y = utm_coords[0];
                double asset_x = utm_coords[1];

                if (asset.getProvide_range() != null && asset.getProvide_range()) {

                    Long obsId = new Random().nextLong();
                    //// TODO, up to here, need to account for different target types having own observations
                    //      currently seeing 4 total obs, expect 8 (2 tgts, 2 assets, 2 obs types)

//                        /* Simple mechanism just for maintaining unique observation ids */
//                    Long obsId = assetToObservationIdMapping.get(asset.getId() + "_" + ObservationType.range.name() + "_" + testTarget.getId());
//                    if (obsId == null) {
//                        obsId = new Random().nextLong();
//                        assetToObservationIdMapping.put(asset.getId() + "_" + ObservationType.range.name() + "_" + testTarget.getId(), obsId);
//                    }
                    //double meas_range = Math.sqrt(Math.pow(a_y-true_y,2) + Math.pow(a_x-true_x,2)) + Math.random()*range_rand_factor; orig
                    double meas_range = ObservationTestHelpers.getRangeMeasurement(asset_y, asset_x, true_y, true_x, range_rand_factor);
                    log.debug("Asset: " + asset.getId() + ", Meas range: " + meas_range);

                    Observation obs = Observation.newBuilder()
                            .setId(new Random().nextLong())
                            .setAssetId(asset.getId())
                            //.setTargetId(testTarget.getId())
                            .setLat(asset.getCurrent_loc()[0])
                            .setLon(asset.getCurrent_loc()[1])
                            .setType(ObservationType.range.name())
                            .setMeas(meas_range).build();

//                    Observation obs = new Observation(obsId, asset.getId(), asset.getCurrent_loc()[0], asset.getCurrent_loc()[1]);
//                    obs.setTargetId(testTarget.getId());
//                    obs.setMeas(meas_range);
//                    obs.setObservationType(ObservationType.range);

//                    try {
//                        efusionProcessManager.addObservation(obs);
//                    } catch (Exception e) {
//                        log.error("Couldn't add observation: " + obs.toString()+":: "+e.getMessage());
//                        e.printStackTrace();
//                    }
                    observations.add(obs);

                }

                //log.debug("TDOA secondary tgts array empty?: "+testTarget.getTdoa_target_ids().isEmpty());

                if (asset.getProvide_tdoa() != null && asset.getProvide_tdoa() && testTarget.getTdoa_target_ids() != null && !testTarget.getTdoa_target_ids().isEmpty()) {
                    /* Second asset that is providing shared tdoa measurement */

                    // TODO, this needs to be rewired such that it should from test target_a to test target_b.

                    for (String secondary_target_id : testTarget.getTdoa_target_ids()) {

                        Long obsId = new Random().nextLong();

//                        Long obsId = assetToObservationIdMapping.get(asset.getId() + ":" + secondary_target_id + "_" + ObservationType.tdoa.name() + "_" + testTarget.getId());
//                        if (obsId == null) {
//                            obsId = new Random().nextLong();
//                            assetToObservationIdMapping.put(asset.getId() + ":" + secondary_target_id + "_" + ObservationType.tdoa.name() + "_" + testTarget.getId(), obsId);
//                        }

                        // TODO, replace this as testTargets instead
//                            TestAsset asset1 = testAssets.get(secondary_target_id);
//                            utm_coords = Helpers.convertLatLngToUtmNthingEasting(asset1.getCurrent_loc()[0], asset1.getCurrent_loc()[1]);
//                            double b_y = utm_coords[0];
//                            double b_x = utm_coords[1];
                        TestTarget target1 = testTargets.get(secondary_target_id);
                        //utm_coords = Helpers.convertLatLngToUtmNthingEasting(target1.getTrue_current_loc()[0], target1.getTrue_current_loc()[1]); // Changed to getTrue.. in Nav, since this is sim observer -- TODO, however need to actually set it in this sim observer
                        utm_coords = Helpers.convertLatLngToUtmNthingEasting(target1.getTrue_lat(), target1.getTrue_lon()); // LATEST: changed to getTrueLat/lon
                        double true_y_b = utm_coords[0]; // This
                        double true_x_b = utm_coords[1];

                        // TODO, change the concept of what is used to get the TDOA measure; should be from tgt1_X/Ytrue, tgt2_X/Ytrue, and known asset location
                        //      this will then have an outer, list of targets iteration, and inner observed assets iteration?

                        // In the original case, a_x/a_y is the sensorAsset, b_x/b_y is the second sensor asset.
                        // Needs to be: (true_y,true_x,true_y_b,true_x_b,<known tower y>,<known tower x>

                        double meas_tdoa = ObservationTestHelpers.getTdoaMeasurement(true_y, true_x, true_y_b, true_x_b, asset_y, asset_x, tdoa_rand_factor);
//                            double meas_tdoa = ObservationTestHelpers.getTdoaMeasurement(a_y, a_x, b_y, b_x, true_y, true_x, tdoa_rand_factor); // ORIGINAL REPLACED IN NAV
                        log.debug("Target: " + testTarget.getId() + ", 2nd Target: " + secondary_target_id + ", Meas tdoa: " + meas_tdoa);

                        Observation obs = Observation.newBuilder()
                                .setId(new Random().nextLong())
                                .setAssetId(asset.getId())
                                //.setTargetId(testTarget.getId())
                                //.setTargetId_b(testTarget.getTdoa_target_ids()[1]) - TDOA CURRENTLY NOT IMPLEMENTED IN NAV
                                //.setLat_b
                                //.setLon_b
                                .setLat(asset.getCurrent_loc()[0])
                                .setLon(asset.getCurrent_loc()[1])
                                .setType(ObservationType.tdoa.name())
                                .setMeas(meas_tdoa).build();

//                        Observation obs_c = new Observation(obsId, asset.getId(), asset.getCurrent_loc()[0], asset.getCurrent_loc()[1]);
//                        obs_c.setTargetId(testTarget.getId());
//                        //obs_c.setAssetId_b(testAssets.get(secondary_asset_id).getId());  /// Replaced with below for Nav use case
//                        obs_c.setTargetId_b(secondary_target_id);
////                            obs_c.setLat_b(target1.getCurrent_loc()[0]); // ALTERED IN NAV, this shouldn't be available in NAV TDOA since unknown target locs???
////                            obs_c.setLon_b(target1.getCurrent_loc()[1]);   /// TODO, confirm how I need to report this, perhaps just need to use current state estimates to draw hyperbola?
//                        obs_c.setMeas(meas_tdoa); // tdoa in seconds
//                        obs_c.setObservationType(ObservationType.tdoa);

//                        try {
//                            efusionProcessManager.addObservation(obs_c);
//                        } catch (Exception e) {
//                            log.error("Couldn't add observation: " + obs_c.toString()+":: "+e.getMessage());
//                            e.printStackTrace();
//                        }
                        //efusionProcessManager.addObservation(obs_c);

                        observations.add(obs);
                    }
                }

                if (asset.getProvide_aoa() != null && asset.getProvide_aoa()) {

//                    Long obsId = assetToObservationIdMapping.get(asset.getId() + "_" + ObservationType.aoa.name() + "_" + testTarget.getId());
//                    if (obsId == null) {
//                        obsId = new Random().nextLong();
//                        assetToObservationIdMapping.put(asset.getId() + "_" + ObservationType.aoa.name() + "_" + testTarget.getId(), obsId);
//                    }
                    double meas_aoa = ObservationTestHelpers.getAoaMeasurement(asset_y, asset_x, true_y, true_x, aoa_rand_factor);
                    log.debug("Asset: " + asset.getId() + ", Meas AOA: " + meas_aoa);

//                    Observation obs_d = new Observation(obsId, asset.getId(), asset.getCurrent_loc()[0], asset.getCurrent_loc()[1]);
//                    obs_d.setTargetId(testTarget.getId());
//                    obs_d.setMeas(meas_aoa); // aoa in radians
//                    obs_d.setObservationType(ObservationType.aoa);

                    Observation obs = Observation.newBuilder()
                            .setId(new Random().nextLong())
                            .setAssetId(asset.getId())
                            //.setTargetId(testTarget.getId())
                            .setLat(asset.getCurrent_loc()[0])
                            .setLon(asset.getCurrent_loc()[1])
                            .setType(ObservationType.aoa.name())
                            .setMeas(meas_aoa).build();

//                    try {
//                        efusionProcessManager.addObservation(obs_d);
//                    } catch (Exception e) {
//                        log.error("Couldn't add observation: " + obs_d.toString()+":: "+e.getMessage());
//                        e.printStackTrace();
//                    }

                    observations.add(obs);
                }
            }
        }
        return observations;
    }
}
