// You are given two arrays with positive integers arr1 and arr2.

// A prefix of a positive integer is an integer formed by one or more of its digits, starting from its leftmost digit. For example, 123 is a prefix of the integer 12345, while 234 is not.

// A common prefix of two integers a and b is an integer c, such that c is a prefix of both a and b. For example, 5655359 and 56554 have common prefixes 565 and 5655 while 1223 and 43456 do not have a common prefix.

// You need to find the length of the longest common prefix between all pairs of integers (x, y) such that x belongs to arr1 and y belongs to arr2.

// Return the length of the longest common prefix among all pairs. If no common prefix exists among them, return 0.
public class findTheLongestCommonPrefix3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // Build all prefixes from arr1 into a HashSet for O(1) lookups.
        java.util.HashSet<String> prefixes = new java.util.HashSet<>();
        for (int num : arr1) {
            String s = Integer.toString(num);
            for (int len = 1; len <= s.length(); len++) {
                prefixes.add(s.substring(0, len));
            }
        }

        int maxPrefixLength = 0;
        // For each number in arr2, check its prefixes from longest to shortest.
        // Stop early when current possible length <= maxPrefixLength.
        for (int num : arr2) {
            String s = Integer.toString(num);
            for (int len = s.length(); len > 0; len--) {
                if (len <= maxPrefixLength) break;
                if (prefixes.contains(s.substring(0, len))) {
                    maxPrefixLength = len;
                    break; // no need to check shorter prefixes for this number
                }
            }
        }

        return maxPrefixLength;
    }
}
}
