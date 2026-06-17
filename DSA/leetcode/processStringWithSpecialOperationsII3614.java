// You are given a string s consisting of lowercase English letters and the special characters: '*', '#', and '%'.

// You are also given an integer k.

// Build a new string result by processing s according to the following rules from left to right:

// If the letter is a lowercase English letter append it to result.
// A '*' removes the last character from result, if it exists.
// A '#' duplicates the current result and appends it to itself.
// A '%' reverses the current result.
// Return the kth character of the final string result. If k is out of the bounds of result, return '.'.
public class processStringWithSpecialOperationsII3614{
    public char processString(String s, int k) {
        long INF = (long) 4e18;

        int n = s.length();
        long[] len = new long[n];

        long cur = 0;

        // Calculate length after each operation
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                cur = Math.min(INF, cur + 1);
            } else if (ch == '*') {
                if (cur > 0) cur--;
            } else if (ch == '#') {
                cur = Math.min(INF, cur * 2);
            } // '%' keeps length unchanged

            len[i] = cur;
        }

        // k out of bounds
        if (k >= cur) {
            return '.';
        }

        // Trace position backwards
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            long currLen = len[i];
            long prevLen = (i == 0) ? 0 : len[i - 1];

            if (ch >= 'a' && ch <= 'z') {
                if (k == prevLen) {
                    return ch;
                }
            } else if (ch == '#') {
                if (k >= prevLen) {
                    k -= prevLen;
                }
            } else if (ch == '%') {
                k = currLen - 1 - k;
            }
            // '*' => k remains unchanged
        }

        return '.';
    }
}