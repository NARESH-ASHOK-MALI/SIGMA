// Given an array arr[], find the maximum sum of a non-empty subarray. You are allowed to skip at most one element in the subarray.

// Note: After skipping the element, the subarray must still be non-empty.

// Examples:

// Input: arr[] = [1, 2, 3, -4, 5]
// Output: 11
// Explanation: We can get maximum sum subarray by skipping -4.
// Input: arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
// Output: 9
// Explanation: We can get maximum sum subarray by skipping -2 as [4,-1,1,5] sums to 9, which is the maximum achievable sum.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// -103 ≤ arr[i] ≤ 103
public class MaxSubarraySumbyRemovingAtMostOne{
    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1] + arr[i]);
        }

        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1] + arr[i]);
        }

        int maxSum = leftMax[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum, leftMax[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            maxSum = Math.max(maxSum, leftMax[i - 1] + rightMax[i + 1]);
        }

        return maxSum;
    }
}