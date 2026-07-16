// Given two integers n and sum, determine the number of n-digit positive integers whose digits add up to sum.

// An n-digit number cannot have leading zeros; that is, the first digit must be between 1 and 9.
// If there exist no n digit number with sum of digits equal to given sum, return -1.
// Examples :

// Input: n = 2, sum = 2
// Output: 2
// Explaination: The valid 2-digit numbers whose digits sum to 2 are 11 and 20.
// Input: n = 1, sum = 10
// Output: -1
// Explaination: A single-digit number can only have a digit sum between 0 and 9.
// Input: n = 2, sum = 10
// Output: 9
// Explaination: The 2-digit numbers whose digits add up to 10 are: 19, 28, 37, 46, 55, 64, 73, 82, 91.
// Constraints:
// 1 ≤ n ≤ 9
// 1 ≤ sum ≤ 81
public class NumbersWithGivenDigitSum {
    public static int countNDigitNumbersWithSum(int n, int sum) {
        // If the sum is less than 1 or greater than the maximum possible sum for n digits, return -1
        if (sum < 1 || sum > 9 * n) {
            return -1;
        }

        // Initialize a DP table where dp[i][j] represents the number of i-digit numbers with a digit sum of j
        int[][] dp = new int[n + 1][sum + 1];

        // Base case: There is one way to have a 0-digit number with a sum of 0
        dp[0][0] = 1;

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                for (int digit = (i == 1 ? 1 : 0); digit <= 9; digit++) {
                    if (j >= digit) {
                        dp[i][j] += dp[i - 1][j - digit];
                    }
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        System.out.println(countNDigitNumbersWithSum(2, 2)); // Output: 2
        System.out.println(countNDigitNumbersWithSum(1, 10)); // Output: -1
        System.out.println(countNDigitNumbersWithSum(2, 10)); // Output: 9
    }
}