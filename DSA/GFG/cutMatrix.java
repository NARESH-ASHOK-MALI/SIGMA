// Given a matrix of 0s and 1s and an integer k, divide the matrix into k pieces such that each piece has at least one 1 in it. A cut can be made in the following way:

// Choose a direction: vertical or horizontal.
// Choose an index to cut the matrix into two pieces.
// If the cut is horizontal, only the bottom part can be cut further.
// If the cut is vertical, only the right part can be cut further.
// Return the number of different ways to divide the matrix modulo 1e9 + 7.

// Examples:

// Input: matrix = [[1, 0, 0], [1, 1, 1], [0, 0,0]], k = 3 
// Output: 3
// Explanation: There are 3 valid ways to divide the matrix into 3 pieces each having at least one 1 - horizontal cut after row 0 then vertical cut after col 0 on bottom, horizontal cut after row 0 then vertical cut after col 1 on bottom, and vertical cut after col 0 then vertical cut after col 1 on the right part.
 
// Input: matrix = [[0, 0], [1, 1]], k = 2
// Output: 1
// Explanation: Only way is to cut vertically in the middle since the top half has no 1.
// Input: matrix = [[1, 0], [0, 0]], k = 1
// Output: 1
// Explanation: No cut needed as k = 1, the whole matrix is one piece with at least one 1.
// Constraints:
// 1 <= n, m, k <= 200
public class cutMatrix{
    static final int MOD = 1000000007;
    public int findWays(int[][] matrix,int k){
        int n = matrix.length, m = matrix[0].length;

        // Build prefix sum of 1s
        int[][] prefix = new int[n+1][m+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                prefix[i][j] = matrix[i][j] 
                             + prefix[i+1][j] 
                             + prefix[i][j+1] 
                             - prefix[i+1][j+1];
            }
        }

        // Helper to check if submatrix has at least one 1
        java.util.function.BiFunction<Integer,Integer,Boolean> hasOne = (r,c) ->
            prefix[r][c] > 0;

        // DP memoization
        Integer[][][] dp = new Integer[n][m][k+1];

        return dfs(0, 0, k, dp, prefix, n, m);
    }

    private int dfs(int r, int c, int pieces, Integer[][][] dp, int[][] prefix, int n, int m) {
        if (dp[r][c][pieces] != null) return dp[r][c][pieces];

        if (prefix[r][c] == 0) return dp[r][c][pieces] = 0; // no 1s
        if (pieces == 1) return dp[r][c][pieces] = 1;       // valid final piece

        long ans = 0;

        // Horizontal cuts
        for (int nr = r+1; nr < n; nr++) {
            if (prefix[r][c] - prefix[nr][c] > 0) { // top part has a 1
                ans += dfs(nr, c, pieces-1, dp, prefix, n, m);
            }
        }

        // Vertical cuts
        for (int nc = c+1; nc < m; nc++) {
            if (prefix[r][c] - prefix[r][nc] > 0) { // left part has a 1
                ans += dfs(r, nc, pieces-1, dp, prefix, n, m);
            }
        }

        return dp[r][c][pieces] = (int)(ans % MOD);
    }
}