// Given two integers n and k, count the number of binary strings of length n where adjacent 1 appear k times.

// Since the answer can be huge, return it modulo 109+7.

// Examples:

// Input: n = 3, k = 2
// Output: 1
// Explanation: Possible string is "111" where 2 adjacent 1 appear.
// Input: n = 5, k = 2
// Output: 6
// Explanation: Possible strings are "00111", "10111", "01110", "11100", "11101" and "11011".
// Constraints:
// 1 ≤ n, k ≤ 103
public class kTimesAppearingAdjacentTwo1s{
    public static int countBinaryStrings(int n, int k) {
        static final int MOD = 1000000007;

    public int countStrings(int n, int k) {
        int[][][] dp = new int[n + 1][k + 1][2];

        // Base case: length 1
        dp[1][0][0] = 1; // "0"
        dp[1][0][1] = 1; // "1"

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // Append '0'
                dp[i][j][0] = (int) (((long) dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD);

                // Append '1'
                dp[i][j][1] = dp[i - 1][j][0]; // previous bit was 0
                if (j > 0) {
                    dp[i][j][1] = (int) (((long) dp[i][j][1] + dp[i - 1][j - 1][1]) % MOD);
                }
            }
        }

        return (int) (((long) dp[n][k][0] + dp[n][k][1]) % MOD);
    }
}
