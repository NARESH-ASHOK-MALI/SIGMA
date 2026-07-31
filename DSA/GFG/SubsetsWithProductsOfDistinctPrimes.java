// Given an integer array arr[], count the number of different subsets whose product can be represented as a product of one or more distinct prime numbers.  Two subsets are considered different if the set of chosen array indexes are not same.

// Return the count modulo 109 + 7.

// Examples:

// Input: arr[] = [1, 2, 3, 4]
// Output: 6
// Explanation: 
// The subsets are:
// [2], product = 2 = 2
// [3], product = 3 = 3
// [1, 2], product = 2 = 2
// [1, 3], product = 3 = 3
// [2, 3], product = 6 = 2 × 3
// [1, 2, 3], product = 6 = 2 × 3
// All these products can be expressed as a product of one or more distinct prime numbers. Hence, the count is 6.
// Note that [4] or any other subset with 4 are not chosen because prducts having 4 have repeated primes 2.
// Input: arr[] = [2, 2, 3]
// Output: 5
// Explanation: 
// Since subsets formed using different indices are considered different, the chosen subsets are:
// [2] (using the first 2)
// [2] (using the second 2)
// [3]
// [2, 3] (using the first 2)
// [2, 3] (using the second 2)
// Each subset has a product that can be expressed as a product of one or more distinct prime numbers. 
// Therefore, the answer is 5.

// Constraints:

// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 30
public class SubsetsWithProductsOfDistinctPrimes{
    static final int MOD = 1_000_000_007;
    static int[] primes = {2,3,5,7,11,13,17,19,23,29};

    public int countSubsets(int[] arr) {
        int n = arr.length;
        int cnt1 = 0;
        List<Integer> masks = new ArrayList<>();

        for (int x : arr) {
            if (x == 1) { cnt1++; continue; }
            int mask = 0;
            boolean valid = true;
            for (int i = 0; i < primes.length; i++) {
                int p = primes[i];
                if (x % (p*p) == 0) { valid = false; break; } // repeated prime
                if (x % p == 0) mask |= (1 << i);
            }
            if (valid) masks.add(mask);
        }

        int[] dp = new int[1 << primes.length];
        dp[0] = 1;

        for (int m : masks) {
            for (int s = (1 << primes.length) - 1; s >= 0; s--) {
                if ((s & m) == 0) {
                    dp[s | m] = (dp[s | m] + dp[s]) % MOD;
                }
            }
        }

        long ans = 0;
        for (int s = 1; s < (1 << primes.length); s++) {
            ans = (ans + dp[s]) % MOD;
        }

        long pow2 = 1;
        for (int i = 0; i < cnt1; i++) pow2 = (pow2 * 2) % MOD;

        ans = (ans * pow2) % MOD;
        // ans = (ans - 1 + MOD) % MOD; // remove only-ones subset

        return (int) ans;
    }
}
