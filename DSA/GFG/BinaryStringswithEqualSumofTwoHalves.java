// Given a number n, find count of all binary sequences of length 2n such that sum of first n bits is same as sum of last n bits. 

// Note: Since the anwer can be very large, so return the answer modulo 109+7.
public class BinaryStringswithEqualSumofTwoHalves{
    static final int MOD = 1000000007;
    static long[] fact;
    static long[] invFact;

    // Fast exponentiation
    static long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    // Precompute factorials and inverse factorials
    static void precompute(int n) {
        fact = new long[2 * n + 1];
        invFact = new long[2 * n + 1];
        fact[0] = 1;
        for (int i = 1; i <= 2 * n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[2 * n] = power(fact[2 * n], MOD - 2);
        for (int i = 2 * n - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    // Compute nCr % MOD
    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    public int computeValue(int n) {
        precompute(n);
        return (int) nCr(2 * n, n);
    }
}
