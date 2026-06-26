// Given two strings, s1 and s2, count the number of subsequences of string s1 equal to string s2.

// Return the total count modulo 1e9+7.

// Examples :

// Input: s1 = "geeksforgeeks", s2 = "gks"
// Output: 4
// Explanation: We can pick characters from s1 as a subsequence from indices [0, 3, 4], [0, 3, 12], [0, 11, 12] and [8, 11, 12]. So total 4 subsequences of s1 that are equal to s2.
// Input: s1 = "problemoftheday", s2 = "geek"
// Output: 0
// Explanation: No subsequence of string s1 is equal to string s2.
// Constraints:
// 1 ≤ s1.size(), s2.size() ≤ 103
public class CountMatchingSubsequences{
    public int countSubsequences(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int mod = 1000000007;

        // Create a DP table to store the counts
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first column (empty string case)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1; // There's one way to match an empty string
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}