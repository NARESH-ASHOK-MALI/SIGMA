// Given a string s consisting of n lowercase characters. Return the lexicographically smallest string after removing exactly k characters from the string. But you have to correct the value of k, i.e., if the length of the string is a power of 2, reduce k by half, else multiply k by 2. You can remove any k characters.

// Note: If it is not possible to remove k (the value of k after correction) characters or if the resulting string is empty return -1.

class Lexicographicallysmallestafterremovingk{
    public String smallestString(String s, int k) {
        int n = s.length();
        if ((n & (n - 1)) == 0) { // Check if n is a power of 2
            k /= 2; // Reduce k by half
        } else {
            k *= 2; // Multiply k by 2
        }
        
        if (k >= n) {
            return "-1"; // Not possible to remove k characters
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            while (result.length() > 0 && result.charAt(result.length() - 1) > c && k > 0) {
                result.deleteCharAt(result.length() - 1); // Remove the last character
                k--; // Decrease k
            }
            result.append(c); // Add the current character
        }
        
        // If there are still characters to remove, remove from the end
        while (k > 0 && result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }
        
        return result.length() == 0 ? "-1" : result.toString(); // Return -1 if the resulting string is empty
    }
}