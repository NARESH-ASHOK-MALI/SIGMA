// Given two arrays a[] and b[] of positive integers of size n and m respectively, where m ≤ n.  You are allowed to insert zeros anywhere into the second array b so that its length becomes equal to n.

// The dot product of two arrays of equal length n is defined as: a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1].
// Return the maximum possible dot product of the two arrays.
// Examples :

// Input: a[] = [2, 3, 1, 7, 8], b[] = [3, 6, 7]
// Output: 107
// Explanation: Maximum dot product is obtained after inserting 0 at the first and third positions in array b.
// Therefore b becomes [0, 3, 0, 6, 7]. 
// Maximum dot product = 2*0 + 3*3 + 1*0 + 7*6 + 8*7 = 107. Therefore answer for this test case is 107.
// Input: a[] = [1, 2, 3], b[] = [4] 
// Output: 12 
// Explanation: Maximum dot product is obtained after inserting 0 at the first and second positions in array b.
// Therefore b becomes [0, 0, 4]. 
// Maximum Dot Product = 1*0 + 2*0 + 3*4 = 12. Therefore answer for this test case is 12.
// Constraints:
// 1 ≤ m ≤ n ≤ 103
// 1 ≤ a[i], b[i] ≤ 103
public class MaxDotProductwith0Insertions{
    public static int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        long[][] dp = new long[n + 1][m + 1];
        long negInf = Long.MIN_VALUE / 4;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = negInf;
            }
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                // Either skip a[i - 1] by inserting 0, or match it with b[j - 1].
                long skip = dp[i - 1][j];
                long take = dp[i - 1][j - 1] + 1L * a[i - 1] * b[j - 1];
                dp[i][j] = Math.max(skip, take);
            }
        }

        return (int) dp[n][m];
    }
}