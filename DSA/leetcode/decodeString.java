// Given an encoded string, return its decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

// You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

// The test cases are generated so that the length of the output will never exceed 105.
public class decodeString {
    public static void main(String[] args) {
        decodeString solution = new decodeString();
        String s = "3[a]2[bc]";
        String result = solution.decodeString(s);
        System.out.println(result); // Output: "aaabcbc"
    }
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int k = 0;
                while (Character.isDigit(s.charAt(i))) {
                    k = k * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i++; // Skip the opening bracket '['
                StringBuilder encodedString = new StringBuilder();
                int bracketCount = 1;
                while (bracketCount > 0) {
                    char currentChar = s.charAt(i);
                    if (currentChar == '[') {
                        bracketCount++;
                    } else if (currentChar == ']') {
                        bracketCount--;
                    }
                    if (bracketCount > 0) {
                        encodedString.append(currentChar);
                    }
                    i++;
                }
                String decodedInner = decodeString(encodedString.toString());
                for (int j = 0; j < k; j++) {
                    result.append(decodedInner);
                }
            } else {
                result.append(c);
                i++;
            }
        }
        return result.toString();
    }
}
