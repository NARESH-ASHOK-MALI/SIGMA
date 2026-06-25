// Given an integer n, return all the n digit numbers in increasing order, such that their digits are in strictly increasing order(from left to right).

// Examples :

// Input: n = 1
// Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// Explanation: Single digit numbers are considered to be strictly increasing order.
// Input: n = 2
// Output: [12, 13, 14, 15, 16, 17, 18, 19, 23....79, 89]
// Explanation: For n = 2, the correct sequence is 12 13 14 15 16 17 18 19 23 and so on up to 89.
// Input: n = 15
// Output: []
// Explanation: No such number exist. 
// Constraints:
// 1 ≤ n ≤ 105
public class n_DigitNumberswithIncreasingDigits{
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n < 1 || n > 10) {
            return result; // Return empty list for invalid n (max 10 digits possible)
        }
        if (n == 1) {
            // For single digit, include 0-9
            generateNumbers(n, 0, -1, result);
        } else {
            // For n > 1, start from 1 to avoid leading zeros
            generateNumbers(n, 0, 0, result);
        }
        return result;
    }
    private static void generateNumbers(int n, int currentNumber, int lastDigit, ArrayList<Integer> result) {
        if (n == 0) {
            result.add(currentNumber);
            return;
        }
        for (int digit = lastDigit + 1; digit <= 9; digit++) {
            generateNumbers(n - 1, currentNumber * 10 + digit, digit, result);
        }
    }
}
