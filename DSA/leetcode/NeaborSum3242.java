// You are given a n x n 2D array grid containing distinct elements in the range [0, n2 - 1].

// Implement the NeighborSum class:

// NeighborSum(int [][]grid) initializes the object.
// int adjacentSum(int value) returns the sum of elements which are adjacent neighbors of value, that is either to the top, left, right, or bottom of value in grid.
// int diagonalSum(int value) returns the sum of elements which are diagonal neighbors of value, that is either to the top-left, top-right, bottom-left, or bottom-right of value in grid.


 

// Example 1:

// Input:

// ["NeighborSum", "adjacentSum", "adjacentSum", "diagonalSum", "diagonalSum"]

// [[[[0, 1, 2], [3, 4, 5], [6, 7, 8]]], [1], [4], [4], [8]]

// Output: [null, 6, 16, 16, 4]

// Explanation:



// The adjacent neighbors of 1 are 0, 2, and 4.
// The adjacent neighbors of 4 are 1, 3, 5, and 7.
// The diagonal neighbors of 4 are 0, 2, 6, and 8.
// The diagonal neighbor of 8 is 4.
// Example 2:

// Input:

// ["NeighborSum", "adjacentSum", "diagonalSum"]

// [[[[1, 2, 0, 3], [4, 7, 15, 6], [8, 9, 10, 11], [12, 13, 14, 5]]], [15], [9]]

// Output: [null, 23, 45]

// Explanation:



// The adjacent neighbors of 15 are 0, 10, 7, and 6.
// The diagonal neighbors of 9 are 4, 12, 14, and 15.
 

// Constraints:

// 3 <= n == grid.length == grid[0].length <= 10
// 0 <= grid[i][j] <= n2 - 1
// All grid[i][j] are distinct.
// value in adjacentSum and diagonalSum will be in the range [0, n2 - 1].
// At most 2 * n2 calls will be made to adjacentSum and diagonalSum.
public class NeaborSum3242 {
    private int[][] grid;
    private int n;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
    }

    public int adjacentSum(int value) {
        int sum = 0;
        int[] pos = findPosition(value);
        if (pos == null) return 0;

        int row = pos[0];
        int col = pos[1];

        // Check top neighbor
        if (row > 0) sum += grid[row - 1][col];
        // Check bottom neighbor
        if (row < n - 1) sum += grid[row + 1][col];
        // Check left neighbor
        if (col > 0) sum += grid[row][col - 1];
        // Check right neighbor
        if (col < n - 1) sum += grid[row][col + 1];

        return sum;
    }

    public int diagonalSum(int value) {
        int sum = 0;
        int[] pos = findPosition(value);
        if (pos == null) return 0;

        int row = pos[0];
        int col = pos[1];

        // Check top-left neighbor
        if (row > 0 && col > 0) sum += grid[row - 1][col - 1];
        // Check top-right neighbor
        if (row > 0 && col < n - 1) sum += grid[row - 1][col + 1];
        // Check bottom-left neighbor
        if (row < n - 1 && col > 0) sum += grid[row + 1][col - 1];
        // Check bottom-right neighbor
        if (row < n - 1 && col < n - 1) sum += grid[row + 1][col + 1];

        return sum;
    }

    private int[] findPosition(int value) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == value) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // Value not found
    }
}