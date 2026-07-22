// Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 

// Example 1:

// Input: s = "bcabc"
// Output: "abc"
// Example 2:

// Input: s = "cbacdcbc"
// Output: "acdb"
 

// Constraints:

// 1 <= s.length <= 104
// s consists of lowercase English letters.
 

// Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
public class RemoveDuplicateLetters316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26]; // Count of each character
        boolean[] visited = new boolean[26]; // To check if character is already in result
        StringBuilder result = new StringBuilder();

        // Count the occurrences of each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            count[c - 'a']--; // Decrease the count for this character

            if (visited[c - 'a']) {
                continue; // If already in result, skip it
            }

            // Remove characters from result that are greater than current character
            // and can still appear later (count > 0)
            while (result.length() > 0 && c < result.charAt(result.length() - 1) && count[result.charAt(result.length() - 1) - 'a'] > 0) {
                visited[result.charAt(result.length() - 1) - 'a'] = false; // Mark as not visited
                result.deleteCharAt(result.length() - 1); // Remove last character
            }

            result.append(c); // Add current character to result
            visited[c - 'a'] = true; // Mark as visited
        }

        return result.toString();
    }
}