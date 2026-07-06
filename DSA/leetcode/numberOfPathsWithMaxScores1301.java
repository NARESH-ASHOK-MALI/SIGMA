// You are given a square board of characters. You can move on the board starting at the bottom right square marked with the character 'S'.

// You need to reach the top left square marked with the character 'E'. The rest of the squares are labeled either with a numeric character 1, 2, ..., 9 or with an obstacle 'X'. In one move you can go up, left or up-left (diagonally) only if there is no obstacle there.

// Return a list of two integers: the first integer is the maximum sum of numeric characters you can collect, and the second is the number of such paths that you can take to get that maximum sum, taken modulo 10^9 + 7.

// In case there is no path, return [0, 0].

 

// Example 1:

// Input: board = ["E23","2X2","12S"]
// Output: [7,1]
// Example 2:

// Input: board = ["E12","1X1","21S"]
// Output: [4,2]
// Example 3:

// Input: board = ["E11","XXX","11S"]
// Output: [0,0]
 

// Constraints:

// 2 <= board.length == board[i].length <= 100
import java.util.*;

public class numberOfPathsWithMaxScores1301{
    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.size(), n = board.get(0).length();
        final int NEG = -1000000000;
        final int MOD = 1_000_000_007;
        int[][] dp = new int[m][n];
        long[][] count = new long[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], NEG);
        dp[m - 1][n - 1] = 0;
        count[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c = board.get(i).charAt(j);
                if (c == 'X') continue;
                if (i == m - 1 && j == n - 1) continue; // start S
                int add = (c >= '0' && c <= '9') ? (c - '0') : 0; // digits only
                int best = NEG;
                long ways = 0;
                // down (i+1, j)
                if (i + 1 < m && dp[i + 1][j] != NEG) {
                    int cand = dp[i + 1][j] + add;
                    if (cand > best) { best = cand; ways = count[i + 1][j]; }
                    else if (cand == best) ways = (ways + count[i + 1][j]) % MOD;
                }
                // right (i, j+1)
                if (j + 1 < n && dp[i][j + 1] != NEG) {
                    int cand = dp[i][j + 1] + add;
                    if (cand > best) { best = cand; ways = count[i][j + 1]; }
                    else if (cand == best) ways = (ways + count[i][j + 1]) % MOD;
                }
                // down-right diag (i+1, j+1)
                if (i + 1 < m && j + 1 < n && dp[i + 1][j + 1] != NEG) {
                    int cand = dp[i + 1][j + 1] + add;
                    if (cand > best) { best = cand; ways = count[i + 1][j + 1]; }
                    else if (cand == best) ways = (ways + count[i + 1][j + 1]) % MOD;
                }
                if (best != NEG) {
                    dp[i][j] = best;
                    count[i][j] = ways % MOD;
                }
            }
        }
        if (count[0][0] == 0) return new int[]{0,0};
        return new int[]{dp[0][0], (int)(count[0][0] % MOD)};
    }
}