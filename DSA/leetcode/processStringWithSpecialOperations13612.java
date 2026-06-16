// You are given a string s consisting of lowercase English letters and the special characters: *, #, and %.

// Build a new string result by processing s according to the following rules from left to right:

// If the letter is a lowercase English letter append it to result.
// A '*' removes the last character from result, if it exists.
// A '#' duplicates the current result and appends it to itself.
// A '%' reverses the current result.
// Return the final string result after processing all characters in s.
public class processStringWithSpecialOperations13612{
    public String processString(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '*':
                    if (result.length() > 0) {
                        result.deleteCharAt(result.length() - 1);
                    }
                    break;
                case '#':
                    result.append(result.toString());
                    break;
                case '%':
                    result.reverse();
                    break;
                default:
                    result.append(c);
            }
        }
        return result.toString();
    }
}