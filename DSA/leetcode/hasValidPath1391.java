// You are given an m x n grid. Each cell of grid represents a street. The street of grid[i][j] can be:

// 1 which means a street connecting the left cell and the right cell.
// 2 which means a street connecting the upper cell and the lower cell.
// 3 which means a street connecting the left cell and the lower cell.
// 4 which means a street connecting the right cell and the lower cell.
// 5 which means a street connecting the left cell and the upper cell.
// 6 which means a street connecting the right cell and the upper cell.
public class hasValidPath1391 {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, visited, 0, 0);
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int m = grid.length, n = grid[0].length;
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        visited[x][y] = true;
        int street = grid[x][y];
        int[][] directions = getDirections(street);
        for (int[] dir : directions) {
            int newX = x + dir[0], newY = y + dir[1];
            if (isValidMove(grid, visited, x, y, newX, newY)) {
                if (dfs(grid, visited, newX, newY)) {
                    return true;
                }
            }
        }
        visited[x][y] = false;
        return false;
    }

    private int[][] getDirections(int street) {
        switch (street) {
            case 1: return new int[][]{{0, -1}, {0, 1}}; // left and right
            case 2: return new int[][]{{-1, 0}, {1, 0}}; // up and down
            case 3: return new int[][]{{0, -1}, {1, 0}}; // left and down
            case 4: return new int[][]{{0, 1}, {1, 0}}; // right and down
            case 5: return new int[][]{{0, -1}, {-1, 0}}; // left and up
            case 6: return new int[][]{{0, 1}, {-1, 0}}; // right and up
            default: return new int[0][];
        }
    }

    private boolean isValidMove(int[][] grid, boolean[][] visited, int x, int y, int newX, int newY) {
        int m = grid.length, n = grid[0].length;
        if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited
                [newX][newY]) {
            return false;
        }
        int newStreet = grid[newX][newY];
        int[][] newDirections = getDirections(newStreet);
        for (int[] dir : newDirections) {
            if (newX + dir[0] == x && newY + dir[1] == y) {
                return true;
            }
        }
        return false;
    }
}