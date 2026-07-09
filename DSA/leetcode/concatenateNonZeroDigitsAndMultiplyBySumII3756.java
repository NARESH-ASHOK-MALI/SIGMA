// You are given a string s of length m consisting of digits. You are also given a 2D integer array queries, where queries[i] = [li, ri].

// For each queries[i], extract the substring s[li..ri]. Then, perform the following:

// Form a new integer x by concatenating all the non-zero digits from the substring in their original order. If there are no non-zero digits, x = 0.
// Let sum be the sum of digits in x. The answer is x * sum.
// Return an array of integers answer where answer[i] is the answer to the ith query.

// Since the answers may be very large, return them modulo 109 + 7.

 

// Example 1:

// Input: s = "10203004", queries = [[0,7],[1,3],[4,6]]

// Output: [12340, 4, 9]

// Explanation:

// s[0..7] = "10203004"
// x = 1234
// sum = 1 + 2 + 3 + 4 = 10
// Therefore, answer is 1234 * 10 = 12340.
// s[1..3] = "020"
// x = 2
// sum = 2
// Therefore, the answer is 2 * 2 = 4.
// s[4..6] = "300"
// x = 3
// sum = 3
// Therefore, the answer is 3 * 3 = 9.
// Example 2:

// Input: s = "1000", queries = [[0,3],[1,1]]

// Output: [1, 0]

// Explanation:

// s[0..3] = "1000"
// x = 1
// sum = 1
// Therefore, the answer is 1 * 1 = 1.
// s[1..1] = "0"
// x = 0
// sum = 0
// Therefore, the answer is 0 * 0 = 0.
// Example 3:

// Input: s = "9876543210", queries = [[0,9]]

// Output: [444444137]

// Explanation:

// s[0..9] = "9876543210"
// x = 987654321
// sum = 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 45
// Therefore, the answer is 987654321 * 45 = 44444444445.
// We return 44444444445 modulo (109 + 7) = 444444137.
 

// Constraints:

// 1 <= m == s.length <= 105
// s consists of digits only.
// 1 <= queries.length <= 105
// queries[i] = [li, ri]
// 0 <= li <= ri < m
public class concatenateNonZeroDigitsAndMultiplyBySumII3756 {
    public int[] substringQueries(String s, int[][] queries) {
        final int mod = 1_000_000_007;
        int n = s.length();

        int[] nonZeroPrefix = new int[n + 1];
        int nonZeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                nonZeroCount++;
            }
            nonZeroPrefix[i + 1] = nonZeroCount;
        }

        int[] digits = new int[nonZeroCount];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '0') {
                digits[idx++] = c - '0';
            }
        }

        long[] pow10 = new long[nonZeroCount + 1];
        long[] prefixValue = new long[nonZeroCount + 1];
        int[] prefixSum = new int[nonZeroCount + 1];
        pow10[0] = 1;
        for (int i = 1; i <= nonZeroCount; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
            prefixValue[i] = (prefixValue[i - 1] * 10 + digits[i - 1]) % mod;
            prefixSum[i] = prefixSum[i - 1] + digits[i - 1];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = nonZeroPrefix[queries[i][0]] + 1;
            int right = nonZeroPrefix[queries[i][1] + 1];

            if (left > right) {
                answer[i] = 0;
                continue;
            }

            long value = prefixValue[right] - (prefixValue[left - 1] * pow10[right - left + 1]) % mod;
            if (value < 0) {
                value += mod;
            }

            long sum = prefixSum[right] - prefixSum[left - 1];
            answer[i] = (int) ((value * sum) % mod);
        }

        return answer;
    }
}