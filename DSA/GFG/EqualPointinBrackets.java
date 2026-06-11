// Given a string s of opening and closing brackets '(' and ')' only, find an equal point in the string. An equal point is a position k (0-based) such that the number of opening brackets before position k is equal to the number of closing brackets from position k to the end of the string. If multiple such points exist, return the first valid position.

// The string can be split at any position from 0 to n, where n is the length of the string.
// If we split at 0, it means there is an empty string on left.
// If we split at n, it means there is an empty string on right.
public class EqualPointInBrackets {
    public static int findEqualPoint(String s) {
        int openCount = 0;
        int closeCount = 0;

        // Count total closing brackets in the string
        for (char c : s.toCharArray()) {
            if (c == ')') {
                closeCount++;
            }
        }

        // Iterate through the string to find the equal point
        for (int k = 0; k <= s.length(); k++) {
            if (openCount == closeCount) {
                return k; // Found the equal point
            }
            if (k < s.length()) {
                if (s.charAt(k) == '(') {
                    openCount++;
                } else if (s.charAt(k) == ')') {
                    closeCount--;
                }
            }
        }

        return -1; // No equal point found
    }

    public static void main(String[] args) {
        String s = "(()))(";
        int equalPoint = findEqualPoint(s);
        System.out.println("Equal point: " + equalPoint);
    }
}