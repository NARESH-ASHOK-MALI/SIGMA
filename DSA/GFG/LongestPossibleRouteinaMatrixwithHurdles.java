// Given a binary matrix mat[][] of size n × m containing values 0 and 1, and four integers xs, ys, xd, and yd representing the source cell (xs, ys) and destination cell (xd, yd), find the length of the longest possible path from the source cell to the destination cell. From any cell, you can move to its adjacent cells in the up, down, left, and right directions.

// 1 represents a traversable cell.
// 0 represents a blocked cell that cannot be visited.
// A cell can be visited at most once in a path.
// If the destination cannot be reached from the source, return -1.
// Examples:

// Input: mat[][] = [[1, 1, 1, 1, 1, 1, 1, 1, 1, 1], [1, 1, 0, 1, 1, 0, 1, 1, 0, 1],[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]], xs = 0, ys = 0, xd = 1, yd = 7
// Output: 24 
// Explanation: The longest valid path from (0, 0) to (1, 7) without revisiting any cell has length 24. 
// Input: mat[][] = [[1, 0, 0, 1, 0],[0, 0, 0, 1, 0],[0, 1, 1, 0, 0]], xs = 0, ys = 3, xd = 2, yd = 2
// Output: -1
// Explanation: The destination cell (2, 2) cannot be reached from the source cell (0, 3), so the answer is -1.
// Constraints:
// 1 ≤ n, m ≤ 10
// mat[i][j] == 0 or mat[i][j] == 1
// The source and destination cells are always inside the matrix.
public class LongestPossibleRouteinaMatrixwithHurdles{
    public static int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        return dfs(mat, xs, ys, xd, yd, visited);
    }
    private static int dfs(int[][] mat, int x, int y, int xd, int yd, boolean[][] visited) {
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] == 0 || visited[x][y]) {
            return -1;
        }
        if (x == xd && y == yd) {
            return 0;
        }
        visited[x][y] = true;
        int maxLength = -1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            int length = dfs(mat, newX, newY, xd, yd, visited);
            if (length != -1) {
                maxLength = Math.max(maxLength, length + 1);
            }
        }
        visited[x][y] = false;
        return maxLength;
    }
}