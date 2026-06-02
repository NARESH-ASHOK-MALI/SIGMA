// You are given two categories of theme park attractions: land rides and water rides.

// Land rides
// landStartTime[i] – the earliest time the ith land ride can be boarded.
// landDuration[i] – how long the ith land ride lasts.
// Water rides
// waterStartTime[j] – the earliest time the jth water ride can be boarded.
// waterDuration[j] – how long the jth water ride lasts.
// A tourist must experience exactly one ride from each category, in either order.

// A ride may be started at its opening time or any later moment.
// If a ride is started at time t, it finishes at time t + duration.
// Immediately after finishing one ride the tourist may board the other (if it is already open) or wait until it opens.
// Return the earliest possible time at which the tourist can finish both rides.
public class earliestFinishTimeForLandAndWaterRidesI3633{
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int earliestFinish = Integer.MAX_VALUE;

        // Check all combinations of land and water rides
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                // Calculate finish time if land ride is taken first
                int landFinishTime = landStartTime[i] + landDuration[i];
                int waterStartAfterLand = Math.max(waterStartTime[j], landFinishTime);
                int totalFinishLandFirst = waterStartAfterLand + waterDuration[j];

                // Calculate finish time if water ride is taken first
                int waterFinishTime = waterStartTime[j] + waterDuration[j];
                int landStartAfterWater = Math.max(landStartTime[i], waterFinishTime);
                int totalFinishWaterFirst = landStartAfterWater + landDuration[i];

                // Update earliest finish time
                earliestFinish = Math.min(earliestFinish, Math.min(totalFinishLandFirst, totalFinishWaterFirst));
            }
        }

        return earliestFinish;
    }
}