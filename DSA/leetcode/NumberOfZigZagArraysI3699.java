// You are given three integers n, l, and r.

// A ZigZag array of length n is defined as follows:

// Each element lies in the range [l, r].
// No two adjacent elements are equal.
// No three consecutive elements form a strictly increasing or strictly decreasing sequence.
// Return the total number of valid ZigZag arrays.

// Since the answer may be large, return it modulo 109 + 7.

// A sequence is said to be strictly increasing if each element is strictly greater than its previous one (if exists).

// A sequence is said to be strictly decreasing if each element is strictly smaller than its previous one (if exists).
public class NumberOfZigZagArraysI3699{
    public int countZigZagArrays(int n, int l, int r) {
        final int mod = 1_000_000_007;
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        long[] up = new long[m];
        long[] down = new long[m];
        for (int i = 0; i < m; i++) {
            up[i] = 1;
            down[i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            long[] nextUp = new long[m];
            long[] nextDown = new long[m];

            long prefix = 0;
            for (int value = 0; value < m; value++) {
                nextUp[value] = prefix;
                prefix += down[value];
                if (prefix >= mod) {
                    prefix -= mod;
                }
            }

            long suffix = 0;
            for (int value = m - 1; value >= 0; value--) {
                nextDown[value] = suffix;
                suffix += up[value];
                if (suffix >= mod) {
                    suffix -= mod;
                }
            }

            up = nextUp;
            down = nextDown;
        }

        long answer = 0;
        for (int value = 0; value < m; value++) {
            answer += up[value];
            answer += down[value];
            answer %= mod;
        }

        return (int) answer;
    }
}