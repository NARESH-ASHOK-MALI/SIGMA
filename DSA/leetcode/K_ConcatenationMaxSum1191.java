// Given an integer array arr and an integer k, modify the array by repeating it k times.

// For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].

// Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.

// As the answer can be very large, return the answer modulo 109 + 7.
public class K_ConcatenationMaxSum1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long MOD = 1_000_000_007L;
        int n = arr.length;
        long totalSum = 0;
        for (int v : arr) totalSum += v;

        long maxDouble = kadane(arr, 2);
        if (k == 1) {
            long maxSingle = kadane(arr, 1);
            return (int) (Math.max(0, maxSingle) % MOD);
        }

        if (k == 2) {
            return (int) (Math.max(0, maxDouble) % MOD);
        }

        long ans;
        if (totalSum > 0) {
            ans = Math.max(0, maxDouble + (k - 2L) * totalSum);
        } else {
            ans = Math.max(0, maxDouble);
        }
        ans %= MOD;
        return (int) ans;
    }

    private long kadane(int[] arr, int times) {
        long maxSoFar = Long.MIN_VALUE;
        long cur = 0;
        int n = arr.length;
        for (int i = 0; i < n * times; i++) {
            int v = arr[i % n];
            cur = Math.max((long) v, cur + v);
            maxSoFar = Math.max(maxSoFar, cur);
        }
        return maxSoFar;
    }
}