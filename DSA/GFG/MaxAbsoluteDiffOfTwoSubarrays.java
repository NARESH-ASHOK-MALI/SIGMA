// Given an array of integers arr[], find two non-overlapping contiguous sub-arrays such that the absolute difference between the sum of two sub-arrays is maximum.

// Examples :

// Input: arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
// Output: 12
// Explanation: Two subarrays are [-2, -3] and [4, -1, -2, 1, 5]
// Input: arr[] = [2, -1, -2, 1, -4, 2, 8]
// Output: 16
// Explanation: Two subarrays are [-1, -2, 1, -4] and [2, 8] 
// Constraints:
// 2 ≤ arr.size() ≤ 105
// -103 ≤ arr[i] ≤ 103
public class MaxAbsoluteDiffOfTwoSubarrays {
    public int maxAbsoluteDiff(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];

        int bestEndingHereMax = arr[0];
        int bestEndingHereMin = arr[0];
        leftMax[0] = arr[0];
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            bestEndingHereMax = Math.max(arr[i], bestEndingHereMax + arr[i]);
            bestEndingHereMin = Math.min(arr[i], bestEndingHereMin + arr[i]);
            leftMax[i] = Math.max(leftMax[i - 1], bestEndingHereMax);
            leftMin[i] = Math.min(leftMin[i - 1], bestEndingHereMin);
        }

        int bestStartingHereMax = arr[n - 1];
        int bestStartingHereMin = arr[n - 1];
        rightMax[n - 1] = arr[n - 1];
        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            bestStartingHereMax = Math.max(arr[i], arr[i] + bestStartingHereMax);
            bestStartingHereMin = Math.min(arr[i], arr[i] + bestStartingHereMin);
            rightMax[i] = Math.max(rightMax[i + 1], bestStartingHereMax);
            rightMin[i] = Math.min(rightMin[i + 1], bestStartingHereMin);
        }

        int maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            maxDiff = Math.max(maxDiff, Math.max(leftMax[i] - rightMin[i + 1], rightMax[i + 1] - leftMin[i]));
        }

        return maxDiff;
    }
}