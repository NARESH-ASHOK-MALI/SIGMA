// A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

// Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.
public class longestHappyPrefix {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            int j = prefix[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefix[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            prefix[i] = j;
        }
        return s.substring(0, prefix[n - 1]);
    }
}
