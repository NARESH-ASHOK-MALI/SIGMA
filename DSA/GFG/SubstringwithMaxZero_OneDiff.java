// Given a binary string s consisting of 0s and 1s. Find the maximum difference
// of the number of 0s and the number of 1s (number of 0s – number of 1s)
// in a substring of the string.
// Note: In the case of all 1s, the answer will be -1.
public class SubstringwithMaxZero_OneDiff {

    public static int maxSubstringDiff(String s) {
        if (s == null || s.length() == 0) return -1;

        int maxDiff = Integer.MIN_VALUE;
        int current = 0;

        for (char c : s.toCharArray()) {
            int val = (c == '0') ? 1 : -1;
            current = Math.max(val, current + val);
            maxDiff = Math.max(maxDiff, current);
        }

        return maxDiff == Integer.MIN_VALUE ? -1 : maxDiff;
    }

    public static void main(String[] args) {
        String[] tests = {
            "1101001", // sample
            "1111",    // all ones -> -1
            "0",       // single zero -> 1
            "101",     // answer 1 (substring "0")
            "10001",   // should find best window
            ""         // empty -> -1
        };

        for (String t : tests) {
            int res = maxSubstringDiff(t);
            System.out.printf("s=\"%s\" -> %d%n", t, res);
        }
    }
}
