// Given a floor of dimensions n × m and an unlimited supply of tiles of size 1 × m, find the total number of ways to completely tile the floor.
// Each tile can be placed in one of the following ways:

// Horizontally, covering 1 row and m columns.
// Vertically, covering m rows and 1 column.
// Count all possible ways to cover the entire floor such that there are no overlaps and no uncovered cells.

// Since the number of possible tilings can be very large, return the answer modulo 109+7.

// Note: n and m are positive integers, and m ≥ 2.
public class waysToTileTheFloor {
    private static final int MOD = 1000000007;

    public static int countWays(int n, int m) {
        // Create an array to store the number of ways to tile the floor
        int[] dp = new int[n + 1];
        
        // Base case: There is 1 way to tile a floor of height 0 (do nothing)
        dp[0] = 1;

        // Fill the dp array for all heights from 1 to n
        for (int i = 1; i <= n; i++) {
            // Place a horizontal tile if possible
            if (i >= 1) {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }
            // Place a vertical tile if possible
            if (i >= m) {
                dp[i] = (dp[i] + dp[i - m]) % MOD;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5; // Height of the floor
        int m = 2; // Width of the tiles
        System.out.println("Total ways to tile the floor: " + countWays(n, m));
    }
}