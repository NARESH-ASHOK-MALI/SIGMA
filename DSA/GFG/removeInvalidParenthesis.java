// Given a string s consisting of lowercase letters and parentheses '(' and ')'.

// A string is considered valid if:

// Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
// Parentheses are properly nested.
// Remove the minimum number of invalid parentheses from s so that the resulting string becomes valid.  Return all the possible distinct valid strings in lexicographically sorted order.
import java.util.*;

public class removeInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        int leftToRemove = 0, rightToRemove = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftToRemove++;
            } else if (c == ')') {
                if (leftToRemove > 0) {
                    leftToRemove--;
                } else {
                    rightToRemove++;
                }
            }
        }

        backtrack(s, 0, leftToRemove, rightToRemove, 0, new StringBuilder(), result);
        List<String> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);
        return sortedResult;
    }
    private void backtrack(String s, int index, int leftToRemove, int rightToRemove, int openCount, StringBuilder current, Set<String> result) {
        if (index == s.length()) {
            if (leftToRemove == 0 && rightToRemove == 0 && openCount == 0) {
                result.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);
        if (c == '(') {
            // Option 1: Remove the '('
            if (leftToRemove > 0) {
                backtrack(s, index + 1, leftToRemove - 1, rightToRemove, openCount, current, result);
            }
            // Option 2: Keep the '('
            current.append(c);
            backtrack(s, index + 1, leftToRemove, rightToRemove, openCount + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        } else if (c == ')') {
            // Option 1: Remove the ')'
            if (rightToRemove > 0) {
                backtrack(s, index + 1, leftToRemove, rightToRemove - 1, openCount, current, result);
            }
            // Option 2: Keep the ')'
            if (openCount > 0) {
                current.append(c);
                backtrack(s, index + 1, leftToRemove, rightToRemove, openCount - 1, current, result);
                current.deleteCharAt(current.length() - 1);
            }
        } else {
            // Just keep the character
            current.append(c);
            backtrack(s, index + 1, leftToRemove, rightToRemove, openCount, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
 