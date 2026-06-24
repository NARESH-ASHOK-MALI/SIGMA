// You are given three integers n, l, and r.

// A ZigZag array of length n is defined as follows:

// Each element lies in the range [l, r].
// No two adjacent elements are equal.
// No three consecutive elements form a strictly increasing or strictly decreasing sequence.
// Return the total number of valid ZigZag arrays.

// Since the answer may be large, return it modulo 109 + 7.

// A sequence is said to be strictly increasing if each element is strictly greater than its previous one (if exists).


// A sequence is said to be strictly decreasing if each element is strictly smaller than its previous one (if exists).
public class NumberOfZigZagArraysII3700{
    private static final int MOD = 1_000_000_007;

    public int countZigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }
        if (n == 2) {
            return (int) ((1L * m * (m - 1)) % MOD);
        }

        int size = 2 * m;

        // State vector layout:
        // [inc[1..m], dec[1..m]]
        // inc[v] = count of arrays ending at value v with last move up
        // dec[v] = count of arrays ending at value v with last move down
        long[] base = new long[size];

        // Length 2 initialization.
        // inc[v] gets choices for first value < v; dec[v] gets choices for first value > v.
        for (int v = 1; v <= m; v++) {
            base[v - 1] = v - 1;
            base[m + (v - 1)] = m - v;
        }

        long[][] transition = buildTransition(m);
        long[][] power = matrixPower(transition, n - 2);
        long[] result = multiplyMatrixVector(power, base);

        long ans = 0;
        for (long val : result) {
            ans += val;
            if (ans >= MOD) {
                ans -= MOD;
            }
        }
        return (int) ans;
    }

    private long[][] buildTransition(int m) {
        int size = 2 * m;
        long[][] t = new long[size][size];

        for (int x = 1; x <= m; x++) {
            int incRow = x - 1;
            int decRow = m + (x - 1);

            // newInc[x] = sum_{v < x} dec[v]
            for (int v = 1; v < x; v++) {
                int decCol = m + (v - 1);
                t[incRow][decCol] = 1;
            }

            // newDec[x] = sum_{v > x} inc[v]
            for (int v = x + 1; v <= m; v++) {
                int incCol = v - 1;
                t[decRow][incCol] = 1;
            }
        }

        return t;
    }

    private long[][] matrixPower(long[][] matrix, int exp) {
        int size = matrix.length;
        long[][] result = new long[size][size];
        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        long[][] base = matrix;
        int e = exp;
        while (e > 0) {
            if ((e & 1) == 1) {
                result = multiplyMatrices(result, base);
            }
            base = multiplyMatrices(base, base);
            e >>= 1;
        }
        return result;
    }

    private long[][] multiplyMatrices(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) {
                    continue;
                }
                long aik = a[i][k];
                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) {
                        continue;
                    }
                    c[i][j] = (c[i][j] + aik * b[k][j]) % MOD;
                }
            }
        }

        return c;
    }

    private long[] multiplyMatrixVector(long[][] matrix, long[] vector) {
        int n = matrix.length;
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 || vector[j] == 0) {
                    continue;
                }
                sum = (sum + matrix[i][j] * vector[j]) % MOD;
            }
            result[i] = sum;
        }

        return result;
    }
}