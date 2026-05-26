// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0]; // Start with the first string as the prefix

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { // Check if the current string starts with the prefix
                prefix = prefix.substring(0, prefix.length() - 1); // Shorten the prefix
                if (prefix.isEmpty()) {
                    return ""; // If the prefix becomes empty, return an empty string
                }
            }
        }

        return prefix; // Return the longest common prefix
    }
}
