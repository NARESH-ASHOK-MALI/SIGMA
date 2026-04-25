public class lengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128]; // ASCII character set
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            start = Math.max(start, lastIndex[currentChar]); // Move start to the right of the last occurrence
            maxLength = Math.max(maxLength, end - start + 1); // Update max length
            lastIndex[currentChar] = end + 1; // Update last index of the current character
        }

        return maxLength;
    }
}
