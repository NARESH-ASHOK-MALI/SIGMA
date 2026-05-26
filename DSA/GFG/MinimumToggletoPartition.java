// Given an array arr[] containing only 0 and 1. Find the minimum toggles (switch from 0 to 1 or vice-versa) required such the array become partitioned, i.e., it has first 0s then 1s.
public class MinimumToggletoPartition {
    public int minToggles(int[] arr) {
        int n = arr.length;
        int totalZeros = 0;
        for (int num : arr) if (num == 0) totalZeros++;

        int zerosRight = totalZeros;
        int onesLeft = 0;
        int minToggles = totalZeros; // split at beginning (all to ones)

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                onesLeft++;
            } else {
                zerosRight--;
            }
            minToggles = Math.min(minToggles, onesLeft + zerosRight);
        }

        return minToggles;
    }
}
