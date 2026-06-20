// Given two integers a and b in the form of strings. Return the last digit of ab.

// Examples:

// Input: a = "3", b = "10"
// Output: 9
// Explanation: 310 = 59049. Last digit is 9.
// Input: a = "6", b = "2"
// Output: 6
// Explanation: 62 = 36. Last digit is 6.
// Constraints:
// 1 ≤ a.size(), b.size() ≤ 1000
// a and b consist only of numeric digits ('0' - '9')
// a and b do not contain any leading zeros, except when number itself is "0"
class LastDigitofab{
    public int lastDigit(String a, String b) {
        if (b.equals("0")) {
            return 1;
        }

        int lastDigitA = a.charAt(a.length() - 1) - '0';
        if (lastDigitA == 0 || lastDigitA == 1 || lastDigitA == 5 || lastDigitA == 6) {
            return lastDigitA;
        }

        int exponentMod = 0;
        for (int i = 0; i < b.length(); i++) {
            exponentMod = (exponentMod * 10 + (b.charAt(i) - '0')) % 4;
        }

        if (exponentMod == 0) {
            exponentMod = 4;
        }

        int[][] cycles = {
            {0},
            {1},
            {2, 4, 8, 6},
            {3, 9, 7, 1},
            {4, 6},
            {5},
            {6},
            {7, 9, 3, 1},
            {8, 4, 2, 6},
            {9, 1}
        };

        int[] cycle = cycles[lastDigitA];
        return cycle[(exponentMod - 1) % cycle.length];
    }
}