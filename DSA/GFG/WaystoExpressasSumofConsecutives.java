// Given a number n, find the number of ways to represent this number as a sum of 2 or more consecutive natural numbers.

// Examples:

// Input: n = 10
// Output: 1
// Explanation: There is only one way, 10 = 1+2+3+4.
// Input: n = 15
// Output: 3
// Explanation: There are 3 ways, (15 = 1+2+3+4+5), (15 = 4+5+6) and (15 = 7+8).
// Constraints:
// 1 ≤ n ≤ 108
public class WaystoExpressasSumofConsecutives{
    public static int countWays(int n) {
        int oddDivisors = 0;
        for (int divisor = 1; divisor * divisor <= n; divisor++) {
            if (n % divisor != 0) {
                continue;
            }

            if ((divisor & 1) == 1) {
                oddDivisors++;
            }

            int pairedDivisor = n / divisor;
            if (pairedDivisor != divisor && (pairedDivisor & 1) == 1) {
                oddDivisors++;
            }
        }

        return oddDivisors - 1;
    }
}