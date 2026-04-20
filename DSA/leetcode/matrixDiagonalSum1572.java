public class matrixDiagonalSum1572 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        System.out.println(matrixSum(grid));
    }
    public static int matrixSum(int[][] grid) {
        int sum = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            sum += grid[i][i]; // Primary diagonal
            if (i != n - 1 - i) { // Avoid double counting the center element in odd-sized matrices
                sum += grid[i][n - 1 - i]; // Secondary diagonal
            }
        }

        return sum;
    }
}
