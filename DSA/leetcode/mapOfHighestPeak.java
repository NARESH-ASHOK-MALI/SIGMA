// You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

// If isWater[i][j] == 0, cell (i, j) is a land cell.
// If isWater[i][j] == 1, cell (i, j) is a water cell.
// You must assign each cell a height in a way that follows these rules:

// The height of each cell must be non-negative.
// If the cell is a water cell, its height must be 0.
// Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
// Find an assignment of heights such that the maximum height in the matrix is maximized.

// Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.
public class mapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with water cells and set their height to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // Directions for adjacent cells (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS to assign heights to land cells
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check if the new cell is within bounds and not visited
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    height[newX][newY] = height[x][y] + 1; // Assign height based on the current cell
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY}); // Add the new cell to the queue
                }
            }
        }

        return height;
    }
}
