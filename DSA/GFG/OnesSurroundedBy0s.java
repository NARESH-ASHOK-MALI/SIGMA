// Given an n × m binary matrix grid[][], find the total count of all cells containing 1 that are unable to move out of the grid through a path of adjacent 1s.

// Adjacency means you can only move in four directions: Up, Down, Left, and Right. Diagonal moves are not allowed.
// Assume that the space immediately outside the grid is an open path. Any 1 located directly on the outer boundary of the grid (first row, last row, first column, or last column) can immediately step out, and any 1 connected to it can follow and also step out of the grid.
public class OnesSurroundedBy0s {
    public int countOnesSurroundedByZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    boolean[] touchesBoundary = new boolean[1];
                    int compSize = dfsCount(grid, visited, i, j, touchesBoundary);
                    if (!touchesBoundary[0]) {
                        count += compSize;
                    }
                }
            }
        }
        

        return count;
    }
    private boolean isConnectedToBoundary(int[][] grid, boolean[][] visited, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        visited[x][y] = true;

        // Check if it's on the boundary
        if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
            return true;
        }

        // Directions: Up, Down, Left, Right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1 && !visited[newX][newY]) {
                if (isConnectedToBoundary(grid, visited, newX, newY)) {
                    return true;
                }
            }
        }

        return false;
    }

    private int dfsCount(int[][] grid, boolean[][] visited, int x, int y, boolean[] touchesBoundary) {
        int n = grid.length;
        int m = grid[0].length;
        visited[x][y] = true;

        // Check if this cell is on the boundary
        if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
            touchesBoundary[0] = true;
        }

        int size = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1 && !visited[newX][newY]) {
                size += dfsCount(grid, visited, newX, newY, touchesBoundary);
            }
        }

        return size;
    }

    public static void main(String[] args) {
        OnesSurroundedBy0s solver = new OnesSurroundedBy0s();

        int[][] grid1 = {
            {0,0,0,0},
            {0,1,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };

        int[][] grid2 = {
            {0,0,0,0},
            {0,1,1,0},
            {0,1,1,1},
            {0,0,0,0}
        };

        int[][] grid3 = {
            {1,0,0},
            {0,1,0},
            {0,0,1}
        };

        int[][] grid4 = {
            {0,0,0,0,0},
            {0,1,0,1,0},
            {0,1,1,1,0},
            {0,0,0,0,0}
        };

        System.out.println("grid1 -> got: " + solver.countOnesSurroundedByZeros(grid1) + " expected: 4");
        System.out.println("grid2 -> got: " + solver.countOnesSurroundedByZeros(grid2) + " expected: 0");
        System.out.println("grid3 -> got: " + solver.countOnesSurroundedByZeros(grid3) + " expected: 1");
        System.out.println("grid4 -> got: " + solver.countOnesSurroundedByZeros(grid4) + " expected: 3");
    }
}
