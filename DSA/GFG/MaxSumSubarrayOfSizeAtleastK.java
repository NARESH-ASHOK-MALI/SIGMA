// Given an array arr[] and an integer k, find the maximum sum among all contiguous subarrays having a length greater than or equal to k.

// Examples:

// Input: arr[] = [1, -2, 2, -3], k = 3
// Output: 1
// Explanation: The sub-array of length at least 3 that produces greatest sum is [1, -2, 2]
// Input: arr[] = [1, 1, 1, 1, 1, 1], k = 2
// Output: 6
// Explanation: The sub-array of length at least 2 that produces greatest sum is [1, 1, 1, 1, 1, 1]
// Input: arr[] = [-4, -2, 1, -3], k = 2
// Output: -1
// Explanation: The sub-array of length at least 2 that produces greatest sum is [-2, 1]

// Constraints:

// 1 ≤ arr.size() ≤ 105
// -104 ≤ arr[i] ≤ 104
// 1 ≤ k ≤ arr.size()
class MaxSumSubarrayOfSizeAtleastK{
    public int maxSumWithK(int arr[], int k) {
        int n = arr.length;

        // Step 1: Kadane’s algorithm to find max subarray sum ending at each index
        int[] maxEnd = new int[n];
        maxEnd[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnd[i] = Math.max(arr[i], arr[i] + maxEnd[i - 1]);
        }

        // Step 2: Prefix sums for quick subarray sum calculation
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        // Step 3: Check subarrays of length >= k
        int result = Integer.MIN_VALUE;
        for (int i = k - 1; i < n; i++) {
            // sum of subarray of length exactly k ending at i
            int sumK = prefix[i + 1] - prefix[i + 1 - k];
            result = Math.max(result, sumK);

            // extend with best prefix before i-k
            if (i >= k) {
                result = Math.max(result, sumK + maxEnd[i - k]);
            }
        }

        return result;
    }
}
