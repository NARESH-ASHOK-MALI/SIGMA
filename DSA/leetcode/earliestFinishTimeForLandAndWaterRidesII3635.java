public class earliestFinishTimeForLandAndWaterRidesII3635{
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;

        long minLandFinish = Long.MAX_VALUE;
        long minWaterFinish = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minLandFinish = Math.min(minLandFinish, (long) landStartTime[i] + landDuration[i]);
        }
        for (int j = 0; j < m; j++) {
            minWaterFinish = Math.min(minWaterFinish, (long) waterStartTime[j] + waterDuration[j]);
        }

        long ans = Long.MAX_VALUE;

        // Take land first, then water
        for (int j = 0; j < m; j++) {
            long finish;
            if (minLandFinish <= waterStartTime[j]) {
                // can finish a land ride before this water opens
                finish = (long) waterStartTime[j] + waterDuration[j];
            } else {
                // have to wait for the earliest land finish
                finish = minLandFinish + waterDuration[j];
            }
            ans = Math.min(ans, finish);
        }

        // Take water first, then land
        for (int i = 0; i < n; i++) {
            long finish;
            if (minWaterFinish <= landStartTime[i]) {
                finish = (long) landStartTime[i] + landDuration[i];
            } else {
                finish = minWaterFinish + landDuration[i];
            }
            ans = Math.min(ans, finish);
        }

        return (int) ans;
    }
}
