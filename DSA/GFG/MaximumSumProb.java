// Given a number n, find its maximum sum value with 3 recursive breaks described below.

// Break into three parts n/2, n/3, and n/4 (consider only the integer part or floor value).
// Each number obtained in this process can be divided further recursively. 
// At every step,  we can take the max of current value of n or the max value obtained with recursive process.
// It is possible that we don't divide the number at all and choose it as final answer.
public class MaximumSumProb {
    public int maxSum(int n) {
        if (n <= 1) return n;

        int half = maxSum(n / 2);
        int third = maxSum(n / 3);
        int quarter = maxSum(n / 4);

        return Math.max(n, half + third + quarter);
    }
}