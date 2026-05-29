// Given a string s consisting of digits, you can split it into contiguous substrings (sub-groups). For example, the string "112" can be split as: ["1","1","2"], ["11","2"], ["1","12"], and ["112"].

// A grouping is considered valid if the sums of digits of the sub-groups form a non-decreasing sequence from left to right.

// Determine the total number of such valid groupings for the given string.
public class CountSortedDigitGroupings {
    public int countValidGroupings(String s) {
        int n = s.length();
        if (n == 0) return 1;
        int maxSum = 9 * n;
        int[][] memo = new int[n + 1][maxSum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxSum; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(0, 0, s, memo);
    }

    private int dfs(int pos, int lastSum, String s, int[][] memo) {
        int n = s.length();
        if (pos == n) return 1;
        if (memo[pos][lastSum] != -1) return memo[pos][lastSum];

        int res = 0;
        int groupSum = 0;
        for (int end = pos; end < n; end++) {
            groupSum += s.charAt(end) - '0';
            if (groupSum >= lastSum) {
                res += dfs(end + 1, groupSum, s, memo);
            }
        }

        memo[pos][lastSum] = res;
        return res;
    }
}