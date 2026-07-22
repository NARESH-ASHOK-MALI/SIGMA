// Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

 

// Example 1:

// Input: s = "bcabc"
// Output: "abc"
// Example 2:

// Input: s = "cbacdcbc"
// Output: "acdb"
 

// Constraints:

// 1 <= s.length <= 1000
// s consists of lowercase English letters.
 

// Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/
public class SmallestSubsequenceOfDistinctCharacters1081 {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        boolean[] seen = new boolean[26];
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a']) continue;
            
            while (result.length() > 0 && c < result.charAt(result.length() - 1) && i < lastIndex[result.charAt(result.length() - 1) - 'a']) {
                seen[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }
            
            result.append(c);
            seen[c - 'a'] = true;
        }
        
        return result.toString();
    }
}