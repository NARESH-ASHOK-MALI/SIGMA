// Given a number n, find count of all binary sequences of length 2n such that sum of first n bits is same as sum of last n bits.

// Note: Since the answer can be very large, return the answer modulo 10^9 + 7.
public class BinaryStringswithEqualSumofTwoHalves {
    private static final int MOD = 1_000_000_007;

    public int computeValue(int n) {
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = (invFact[i] * i) % MOD;
        }

        long answer = 0;
        for (int k = 0; k <= n; k++) {
            long ways = fact[n];
            ways = (ways * invFact[k]) % MOD;
            ways = (ways * invFact[n - k]) % MOD;
            answer = (answer + (ways * ways) % MOD) % MOD;
        }

        return (int) answer;
    }

    private long modPow(long base, int exponent) {
        long result = 1;
        long value = base % MOD;
        int power = exponent;

        while (power > 0) {
            if ((power & 1) == 1) {
                result = (result * value) % MOD;
            }
            value = (value * value) % MOD;
            power >>= 1;
        }

        return result;
    }
}
