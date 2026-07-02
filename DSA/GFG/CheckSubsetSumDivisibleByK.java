// Given an array arr[] of positive integers and a value k. Return true if the sum of any non-empty subset of the given array is divisible by k otherwise, return false.

// Examples:

// Input: arr[] = [3, 1, 7, 5] , k = 6
// Output: true
// Explanation: If we take the subset {7, 5} then sum will be 12 which is divisible by 6.
// Input: arr[] = [1, 2, 6] , k = 5
// Output: false
// Explanation: All possible subsets of the given set are {1}, {2}, {6}, {1, 2}, {2, 6}, {1, 6} and {1, 2, 6}. There is no subset whose sum is divisible by 5.
// Constraints:
// 1 ≤ arr.size(), k ≤ 103
// 1 ≤ arr[i] ≤ 103
public class CheckSubsetSumDivisibleByK{
    public static boolean isSubsetSumDivisibleByK(int[] arr, int k) {
        int n = arr.length;
        boolean[] dp = new boolean[k];

        for (int num : arr) {
            int rem = num % k;
            if (rem == 0) return true; // single element divisible by k
            boolean[] newDp = dp.clone();
            newDp[rem] = true; // subset consisting of only 'num'
            for (int j = 0; j < k; j++) {
                if (dp[j]) {
                    newDp[(j + rem) % k] = true;
                }
            }
            dp = newDp;
        }

        return dp[0]; // Check if there is a non-empty subset sum divisible by k
    }
}