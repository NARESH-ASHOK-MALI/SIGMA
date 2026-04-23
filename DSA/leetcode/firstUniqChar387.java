// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
public class firstUniqChar387 {
    public static int firstUniqChar(String s) {
        // Count the frequency of each character
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        // If no unique character is found, return -1
        return -1;
    }
}
