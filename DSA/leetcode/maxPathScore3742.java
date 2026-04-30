// You are given an m x n grid where each cell contains one of the values 0, 1, or 2. You are also given an integer k.

// You start from the top-left corner (0, 0) and want to reach the bottom-right corner (m - 1, n - 1) by moving only right or down.

// Each cell contributes a specific score and incurs an associated cost, according to their cell values:

// 0: adds 0 to your score and costs 0.
// 1: adds 1 to your score and costs 1.
// 2: adds 2 to your score and costs 1. ​​​​​​​
// Return the maximum score achievable without exceeding a total cost of k, or -1 if no valid path exists.

// Note: If you reach the last cell but the total cost exceeds k, the path is invalid.
public class maxPathScore3742 {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        
        // dp[i][j][c] = maximum score at (i,j) with cost c
        // -1 means unreachable
        int[][][] dp = new int[m][n][k + 1];
        
        // Initialize all states as unreachable
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }
        
        // Base case: starting cell (0, 0)
        int startCost = grid[0][0] == 2 ? 1 : grid[0][0];
        int startScore = grid[0][0];
        if (startCost <= k) {
            dp[0][0][startCost] = startScore;
        }
        
        // Fill DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                
                int cellCost = grid[i][j] == 2 ? 1 : grid[i][j];
                int cellScore = grid[i][j];
                
                // From top
                if (i > 0) {
                    for (int c = cellCost; c <= k; c++) {
                        if (dp[i - 1][j][c - cellCost] != -1) {
                            dp[i][j][c] = Math.max(dp[i][j][c], 
                                                    dp[i - 1][j][c - cellCost] + cellScore);
                        }
                    }
                }
                
                // From left
                if (j > 0) {
                    for (int c = cellCost; c <= k; c++) {
                        if (dp[i][j - 1][c - cellCost] != -1) {
                            dp[i][j][c] = Math.max(dp[i][j][c], 
                                                    dp[i][j - 1][c - cellCost] + cellScore);
                        }
                    }
                }
            }
        }
        
        // Find maximum score at destination with any cost <= k
        int result = -1;
        for (int c = 0; c <= k; c++) {
            if (dp[m - 1][n - 1][c] != -1) {
                result = Math.max(result, dp[m - 1][n - 1][c]);
            }
        }
        return result;
    }
}
