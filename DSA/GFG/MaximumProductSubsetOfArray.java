// Given an array arr[], find and return the maximum product possible with the subset of elements present in the array.

// Note:

// The maximum product can be of a single element also.
// Since the product can be large, return it modulo 109 + 7.
public class MaximumProductSubsetOfArray {
    public int maxProduct(int[] arr) {
        long mod = 1000000007L;
        long product = 1L;
        int negativeCount = 0;
        int zeroCount = 0;
        int maxNegative = Integer.MIN_VALUE; // closest to zero negative
        int nonZeroCount = 0;

        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            nonZeroCount++;
            if (num < 0) {
                negativeCount++;
                if (num > maxNegative) maxNegative = num;
            }
            product = (product * Math.abs((long)num)) % mod;
        }

        if (nonZeroCount == 0) return 0; // all zeros

        if ((negativeCount & 1) == 1) {
            // If there's exactly one negative and it's the only non-zero element
            if (negativeCount == 1 && nonZeroCount == 1) {
                // choose 0 if there are zeros, otherwise return that negative value
                if (zeroCount > 0) return 0;
                return maxNegative;
            }
            // exclude the negative closest to zero
            product = (product * modInverse(Math.abs((long)maxNegative), mod)) % mod;
        }

        return (int)(product % mod);
    }

    private long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }

    private long modPow(long a, long e, long mod) {
        long res = 1L;
        a %= mod;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            e >>= 1;
        }
        return res;
    }

    
}
