// You are given a 2D matrix grid of size n x n. Initially, all cells of the grid are colored white. In one operation, you can select any cell of indices (i, j), and color black all the cells of the jth column starting from the top row down to the ith row.

// The grid score is the sum of all grid[i][j] such that cell (i, j) is white and it has a horizontally adjacent black cell.

// Return the maximum score that can be achieved after some number of operations.
public class maximumScore3225 {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        long[][] pref = new long[n][n + 1];
        for (int c = 0; c < n; c++) {
            pref[c][0] = 0;
            for (int r = 0; r < n; r++) pref[c][r + 1] = pref[c][r] + grid[r][c];
        }

        final long NEG = Long.MIN_VALUE / 4;
        // dp[p][s] = max score up to column j-1 with r_{j-2}=p and r_{j-1}=s
        long[][] dpPrev = new long[n + 1][n + 1];
        for (int p = 0; p <= n; p++) for (int s = 0; s <= n; s++) dpPrev[p][s] = 0;

        for (int j = 1; j < n; j++) {
            long[][] dpNext = new long[n + 1][n + 1];
            for (int a = 0; a <= n; a++) for (int b = 0; b <= n; b++) dpNext[a][b] = NEG;
            int L = j - 1, R = j;

            // For each s, compute needed prefix/suffix maxima over p to evaluate max over p quickly
            for (int s = 0; s <= n; s++) {
                // max over p in [0..s] of dpPrev[p][s]
                long maxA = NEG;
                for (int p = 0; p <= s; p++) maxA = Math.max(maxA, dpPrev[p][s]);

                // suffMax[p] = max_{q >= p} dpPrev[q][s]
                long[] suffMax = new long[n + 1];
                long cur = NEG;
                for (int p = n; p >= 0; p--) {
                    cur = Math.max(cur, dpPrev[p][s]);
                    suffMax[p] = cur;
                }
                long maxAllP = suffMax[0];

                long curMaxB = NEG; // max over p in (s..t-1] of dpPrev[p][s] - pref[L][p]
                for (int t = 0; t <= n; t++) {
                    // when including p = t-1 into (s..t-1], update curMaxB
                    if (t - 1 > s) {
                        int p = t - 1;
                        curMaxB = Math.max(curMaxB, dpPrev[p][s] - pref[L][p]);
                    }

                    long pair = 0;
                    if (s < t) {
                        pair = pref[L][t] - pref[L][s];
                    } else if (t < s) {
                        pair = pref[R][s] - pref[R][t];
                    }

                    long best = NEG;
                    if (s >= t) {
                        // triple is always zero when s >= t
                        if (maxAllP != NEG) best = Math.max(best, maxAllP + pair);
                    } else {
                        if (maxA != NEG) best = Math.max(best, maxA + pair);
                        if (curMaxB != NEG) best = Math.max(best, curMaxB + pair + pref[L][s]);
                        if (suffMax[t] != NEG) best = Math.max(best, suffMax[t] + pair - pref[L][t] + pref[L][s]);
                    }

                    dpNext[s][t] = best;
                }
            }

            dpPrev = dpNext;
        }

        long ans = NEG;
        for (int p = 0; p <= n; p++) for (int s = 0; s <= n; s++) ans = Math.max(ans, dpPrev[p][s]);
        return ans;
    }

    // quick local test for provided examples
    public static void main(String[] args) {
        maximumScore3225 s = new maximumScore3225();
        int[][] grid1 = {
            {0,0,0,0,0},
            {0,0,3,0,0},
            {0,1,0,0,0},
            {5,0,0,3,0},
            {0,0,0,0,2}
        };
        System.out.println("Output1: " + s.maximumScore(grid1));

        int[][] grid2 = {
            {10,9,0,0,15},
            {7,1,0,8,0},
            {5,20,0,11,0},
            {0,0,0,1,2},
            {8,12,1,10,3}
        };
        System.out.println("Output2: " + s.maximumScore(grid2));
    }
}
