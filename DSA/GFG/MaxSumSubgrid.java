// Given a n × n grid mat[][] of integers where values can be negative, find the maximum sum among all possible k × k sub-grids.

// Examples:

// Input: k = 3, mat[][] = [[1, 2, -1, 4], [-8, -3, 4, 2], [3, 8, 10, -8], [-4, -1, 1, 7]]
// Output: 20
// Explanation: The 3 × 3 sub-grid [[-3, 4, 2], [8, 10, -8], [-1, 1, 7]] highlighted in red has the maximum sum of 20. 








// Input: k = 1, mat[][] = [[4]]
// Output: 4
// Explanation: Only one 1×1 sub-grid exists with sum 4.

// Constraints:

// 1 ≤ n ≤ 1000
// 1 ≤ k ≤ n
// -1000 ≤ mat[i][j] ≤ 1000
public class MaxSumSubgrid {
    public static int maxSumSubgrid(int[][] mat, int k) {
        int n = mat.length;
        int maxSum = Integer.MIN_VALUE;

        // Create a prefix sum matrix
        int[][] prefixSum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = mat[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        // Iterate through all possible k x k sub-grids
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= n; j++) {
                int currentSum = prefixSum[i][j] - prefixSum[i - k][j] - prefixSum[i][j - k] + prefixSum[i - k][j - k];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1, 2, -1, 4}, {-8, -3, 4, 2}, {3, 8, 10, -8}, {-4, -1, 1, 7}};
        int k1 = 3;
        System.out.println(maxSumSubgrid(mat1, k1)); // Output: 20

        int[][] mat2 = {{4}};
        int k2 = 1;
        System.out.println(maxSumSubgrid(mat2, k2)); // Output: 4
    }
}