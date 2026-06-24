// Given a matrix mat[][] of size n × n, where mat[i][j] represents the maximum number of steps a rat can jump either forward (right) or downward from that cell, find a path for the rat to reach from the top-left cell (0, 0) to the bottom-right cell (n - 1, n - 1). A cell containing 0 is blocked and cannot be used in the path. It is guaranteed that the cell mat[n-1][n-1] is not 0.

// Return an n × n matrix where 1 represents the cells included in the path and 0 represents the remaining cells. If no valid path exists, return [[-1]].

// Note: If multiple valid paths exist, choose the path with the shortest possible jumps first. For the same jump length, moving forward (right) should be preferred over moving downward.
import java.util.ArrayList;
import java.util.Arrays;

public class RatMazeWithMultipleJumps{
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        if (n == 0) {
            ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
            noPath.add(new ArrayList<>(Arrays.asList(-1)));
            return noPath;
        }

        if (n == 1) {
            ArrayList<ArrayList<Integer>> single = new ArrayList<>();
            single.add(new ArrayList<>(Arrays.asList(1)));
            return single;
        }

        if (mat[0][0] == 0) {
            ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
            noPath.add(new ArrayList<>(Arrays.asList(-1)));
            return noPath;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            result.add(row);
        }

        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        if (!canReach(mat, 0, 0, memo)) {
            ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
            noPath.add(new ArrayList<>(Arrays.asList(-1)));
            return noPath;
        }

        buildPath(mat, 0, 0, memo, result);
        return result;
    }

    private boolean canReach(int[][] mat, int x, int y, int[][] memo) {
        int n = mat.length;

        if (!isSafe(mat, x, y)) {
            return false;
        }

        if (x == n - 1 && y == n - 1) {
            memo[x][y] = 1;
            return true;
        }

        if (memo[x][y] != -1) {
            return memo[x][y] == 1;
        }

        for (int jump = 1; jump <= mat[x][y]; jump++) {
            int rightY = y + jump;
            if (rightY < n && canReach(mat, x, rightY, memo)) {
                memo[x][y] = 1;
                return true;
            }

            int downX = x + jump;
            if (downX < n && canReach(mat, downX, y, memo)) {
                memo[x][y] = 1;
                return true;
            }
        }

        memo[x][y] = 0;
        return false;
    }

    private void buildPath(int[][] mat, int x, int y, int[][] memo, ArrayList<ArrayList<Integer>> result) {
        int n = mat.length;
        result.get(x).set(y, 1);

        if (x == n - 1 && y == n - 1) {
            return;
        }

        for (int jump = 1; jump <= mat[x][y]; jump++) {
            int rightY = y + jump;
            if (rightY < n && memo[x][rightY] == 1) {
                buildPath(mat, x, rightY, memo, result);
                return;
            }

            int downX = x + jump;
            if (downX < n && memo[downX][y] == 1) {
                buildPath(mat, downX, y, memo, result);
                return;
            }
        }
    }

    private boolean isSafe(int[][] mat, int x, int y) {
        int n = mat.length;
        return (x >= 0 && x < n && y >= 0 && y < n && mat[x][y] != 0);
    }
}