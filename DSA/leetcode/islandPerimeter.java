// You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

// Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

// The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
public class islandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4; // Each land cell contributes 4 to the perimeter

                    // Check the right and down neighbors to avoid double counting
                    if (i + 1 < rows && grid[i + 1][j] == 1) {
                        perimeter -= 2; // Shared edge with the cell below
                    }
                    if (j + 1 < cols && grid[i][j + 1] == 1) {
                        perimeter -= 2; // Shared edge with the cell to the right
                    }
                }
            }
        }

        return perimeter;
    }
}
