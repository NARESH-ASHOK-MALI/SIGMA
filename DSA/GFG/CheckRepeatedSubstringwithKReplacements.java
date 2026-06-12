// Given a string s and an integer k, check if it is possible to convert s to a string that is repetition of a substring with k characters else returns false. In order to convert we can replace one substring of length k with any k characters.

// Note:  In one operation, you can replace any substring of length k whose starting index i (0-based) satisfies i % k == 0 with any sequence of k characters.
public class CheckRepeatedSubstringwithKReplacements{
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n % k != 0) {
            return false;
        }

        int blocks = n / k;
        java.util.Map<String, Integer> frequency = new java.util.HashMap<>();
        for (int i = 0; i < n; i += k) {
            String block = s.substring(i, i + k);
            frequency.put(block, frequency.getOrDefault(block, 0) + 1);
        }

        for (int count : frequency.values()) {
            if (count >= blocks - 1) {
                return true;
            }
        }
        return false;
    }
}