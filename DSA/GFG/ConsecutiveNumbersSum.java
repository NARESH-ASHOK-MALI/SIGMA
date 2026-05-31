// Given a number n, find whether n can be expressed as sum of two or more consecutive positive numbers.
public class ConsecutiveNumbersSum {
    public boolean consecutiveNumbersSum(int n) {
        // A number can be written as a sum of two or more consecutive positive integers
        // iff it is NOT a power of two.
        // So return true when n is not a power of two.
        return (n & (n - 1)) != 0;
    }
}