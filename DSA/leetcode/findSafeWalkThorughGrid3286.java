import java.util.*;

// You are given an m x n binary matrix grid and an integer health.
// You start on the upper-left corner (0, 0) and would like to get to the lower-right corner (m - 1, n - 1).
// You can move up, down, left, or right. Cells with value 1 cost 1 health point when entered.
// Return true if you can reach the final cell with health >= 1.
public class findSafeWalkThorughGrid3286{
    public boolean canReachEnd(List<List<Integer>> grid, int health) {
        int m = grid.size();
        if (m == 0) return false;
        int n = grid.get(0).size();
        if (n == 0) return false;

        // Deduct starting cell cost immediately
        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;

        // best[i][j] holds the maximum remaining health we've had upon reaching (i,j).
        int[][] best = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(best[i], -1);

        Deque<int[]> q = new ArrayDeque<>();
        best[0][0] = startHealth;
        q.offer(new int[]{0, 0, startHealth});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1], h = cur[2];
            if (i == m - 1 && j == n - 1) return true;
            for (int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];
                if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;
                int nh = h - grid.get(ni).get(nj);
                if (nh <= 0) continue; // cannot proceed if health drops to 0 or below
                if (nh <= best[ni][nj]) continue; // no improvement
                best[ni][nj] = nh;
                q.offer(new int[]{ni, nj, nh});
            }
        }
        return false;
    }
}