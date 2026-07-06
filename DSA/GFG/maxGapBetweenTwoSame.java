// Given a string s consisting of lowercase English letters, find the maximum number of characters between any two identical characters. If no character repeats, return -1.

// Examples :

// Input: s = "socks"
// Output: 3
// Explanation: There are 3 characters between the two occurrences of 's'.
// Input: s = "for"
// Output: -1
// Explanation: No repeating character present.
// Constraints:
// 1 ≤ |s| ≤ 105
public class maxGapBetweenTwoSame{
    public static int maxGap(String s) {
        int maxGap = -1;
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];

        // Initialize with -1
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
            lastIndex[i] = -1;
        }

        // Record first and last occurrence
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (firstIndex[index] == -1) {
                firstIndex[index] = i;
            }
            lastIndex[index] = i;
        }

        // Compute max gap
        for (int i = 0; i < 26; i++) {
            if (firstIndex[i] != -1 && lastIndex[i] != -1 && firstIndex[i] != lastIndex[i]) {
                int gap = lastIndex[i] - firstIndex[i] - 1;
                maxGap = Math.max(maxGap, gap);
            }
        }

        return maxGap;
    }
}
