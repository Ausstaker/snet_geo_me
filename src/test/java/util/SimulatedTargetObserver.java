package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import au.com.ausstaker.cage.EfusionProcessManager;
import au.com.ausstaker.cage.model.Observation;
import au.com.ausstaker.cage.model.ObservationType;
import au.com.ausstaker.cage.util.Helpers;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TimerTask;

/**
 * Simulate new observations following target
 * @author edge2ipi (https://github.com/Ausstaker)
 */
public class SimulatedTargetObserver extends TimerTask {

    private static final Logger log = LoggerFactory.getLogger(SimulatedTargetObserver.class);

    EfusionProcessManager efusionProcessManager;

//    double true_lat; double true_lon;

    Map<String,TestAsset> testAssets = new HashMap<String,TestAsset>();

    // TODO, now also need to hold a map of testTargets ???
    Map<String,TestTarget> testTargets = new HashMap<String,TestTarget>();

    double range_rand_factor; // = 0; /* Guide: 50 [m] */
    double tdoa_rand_factor; // = 0.0000001; /* Guide: 0.0000001 [sec] */
    double aoa_rand_factor; // = 0; /* Guide: 0.1 [radians] */

//    double lat_move; // = 0.001;
//    double lon_move; // = 0.001;

    /* Simple mechanism to maintain observation ids for different assets to targets. Similar method should be implemented in client logic */
    Map<String,Long> assetToObservationIdMapping = new HashMap<String,Long>();

    @Override
    public void run() {

        log.debug("Running sim observer");

        // Update all sim targets locations first - to allow location information known to secondary assets
        for (TestTarget testTarget :testTargets.values()) {
            // Generate lat,lon path of movement according to simple movement model
            testTarget.setTrue_lat(testTarget.getTrue_lat() + testTarget.getLat_move());
            testTarget.setTrue_lon(testTarget.getTrue_lon() + testTarget.getLon_move());
            log.debug("Moving Observer, moved target: "+testTarget.getId()+", to: " + testTarget.getTrue_lat() + "," + testTarget.getTrue_lon());

            // update GeoMission::Target::TrueLocation
            // Just for plotting and engineering purposes.
            efusionProcessManager.getGeoMission().getTarget().setTrue_current_loc(new Double[]{testTarget.getTrue_lat(), testTarget.getTrue_lon()});
        }


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

                //try {
                    if (asset.getProvide_range() != null && asset.getProvide_range()) {

                        //// TODO, up to here, need to account for different target types having own observations
                        //      currently seeing 4 total obs, expect 8 (2 tgts, 2 assets, 2 obs types)

                        /* Simple mechanism just for maintaining unique observation ids */
                        Long obsId = assetToObservationIdMapping.get(asset.getId() + "_" + ObservationType.range.name() + "_" + testTarget.getId());
                        if (obsId == null) {
                            obsId = new Random().nextLong();
                            assetToObservationIdMapping.put(asset.getId() + "_" + ObservationType.range.name() + "_" + testTarget.getId(), obsId);
                        }
                        //double meas_range = Math.sqrt(Math.pow(a_y-true_y,2) + Math.pow(a_x-true_x,2)) + Math.random()*range_rand_factor; orig
                        double meas_range = ObservationTestHelpers.getRangeMeasurement(asset_y, asset_x, true_y, true_x, range_rand_factor);
                        log.debug("Asset: " + asset.getId() + ", Meas range: " + meas_range);

                        Observation obs = new Observation(obsId, asset.getId(), asset.getCurrent_loc()[0], asset.getCurrent_loc()[1]);
                        obs.setTargetId(testTarget.getId());
                        obs.setMeas(meas_range);
                        obs.setObservationType(ObservationType.range);

                        try {
                            efusionProcessManager.addObservation(obs);
                        } catch (Exception e) {
                            log.error("Couldn't add observation: " + obs.toString()+":: "+e.getMessage());
                            e.printStackTrace();
                        }

                    }

                    //log.debug("TDOA secondary tgts array empty?: "+testTarget.getTdoa_target_ids().isEmpty());

                    if (asset.getProvide_tdoa() != null && asset.getProvide_tdoa() && testTarget.getTdoa_target_ids() != null && !testTarget.getTdoa_target_ids().isEmpty()) {
                    /* Second asset that is providing shared tdoa measurement */

                        // TODO, this needs to be rewired such that it should from test target_a to test target_b.

                        for (String secondary_target_id : testTarget.getTdoa_target_ids()) {
                            Long obsId = assetToObservationIdMapping.get(asset.getId() + ":" + secondary_target_id + "_" + ObservationType.tdoa.name() + "_" + testTarget.getId());
                            if (obsId == null) {
                                obsId = new Random().nextLong();
                                assetToObservationIdMapping.put(asset.getId() + ":" + secondary_target_id + "_" + ObservationType.tdoa.name() + "_" + testTarget.getId(), obsId);
                            }

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

                            Observation obs_c = new Observation(obsId, asset.getId(), asset.getCurrent_loc()[0], asset.getCurrent_loc()[1]);
                            obs_c.setTargetId(testTarget.getId());
                            //obs_c.setAssetId_b(testAssets.get(secondary_asset_id).getId());  /// Replaced with below for Nav use case
                            obs_c.setTargetId_b(secondary_target_id);
//                            obs_c.setLat_b(target1.getCurrent_loc()[0]); // ALTERED IN NAV, this shouldn't be available in NAV TDOA since unknown target locs???
//                            obs_c.setLon_b(target1.getCurrent_loc()[1]);   /// TODO, confirm how I need to report this, perhaps just need to use current state estimates to draw hyperbola?
                            obs_c.setMeas(meas_tdoa); // tdoa in seconds
                            obs_c.setObservationType(ObservationType.tdoa);

                            try {
                                efusionProcessManager.addObservation(obs_c);
                            } catch (Exception e) {
                                log.error("Couldn't add observation: " + obs_c.toString()+":: "+e.getMessage());
                                e.printStackTrace();
                            }
                            //efusionProcessManager.addObservation(obs_c);
                        }
                    }

                    if (asset.getProvide_aoa() != null && asset.getProvide_aoa()) {
                        Long obsId = assetToObservationIdMapping.get(asset.getId() + "_" + ObservationType.aoa.name() + "_" + testTarget.getId());
                        if (obsId == null) {
                            obsId = new Random().nextLong();
                            assetToObservationIdMapping.put(asset.getId() + "_" + ObservationType.aoa.name() + "_" + testTarget.getId(), obsId);
                        }
                        double meas_aoa = ObservationTestHelpers.getAoaMeasurement(asset_y, asset_x, true_y, true_x, aoa_rand_factor);
                        log.debug("Asset: " + asset.getId() + ", Meas AOA: " + meas_aoa);

                        Observation obs_d = new Observation(obsId, asset.getId(), asset.getCurrent_loc()[0], asset.getCurrent_loc()[1]);
                        obs_d.setTargetId(testTarget.getId());
                        obs_d.setMeas(meas_aoa); // aoa in radians
                        obs_d.setObservationType(ObservationType.aoa);

                        try {
                            efusionProcessManager.addObservation(obs_d);
                        } catch (Exception e) {
                            log.error("Couldn't add observation: " + obs_d.toString()+":: "+e.getMessage());
                            e.printStackTrace();
                        }
                    }
            }
        }
    }

    public EfusionProcessManager getEfusionProcessManager() {
        return efusionProcessManager;
    }

    public void setEfusionProcessManager(EfusionProcessManager efusionProcessManager) {
        this.efusionProcessManager = efusionProcessManager;
    }

    public double getRange_rand_factor() {
        return range_rand_factor;
    }

    public void setRange_rand_factor(double range_rand_factor) {
        this.range_rand_factor = range_rand_factor;
    }

    public double getTdoa_rand_factor() {
        return tdoa_rand_factor;
    }

    public void setTdoa_rand_factor(double tdoa_rand_factor) {
        this.tdoa_rand_factor = tdoa_rand_factor;
    }

    public double getAoa_rand_factor() {
        return aoa_rand_factor;
    }

    public void setAoa_rand_factor(double aoa_rand_factor) {
        this.aoa_rand_factor = aoa_rand_factor;
    }

    public Map<String, TestAsset> getTestAssets() {
        return testAssets;
    }

    public void setTestAssets(Map<String, TestAsset> testAssets) {
        this.testAssets = testAssets;
    }

    public Map<String, TestTarget> getTestTargets() {
        return testTargets;
    }

    public void setTestTargets(Map<String, TestTarget> testTargets) {
        this.testTargets = testTargets;
    }
}
