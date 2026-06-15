// Given a matrix mat[][] of size n × m consisting of 0s and 1s. You start at the top-left cell (0, 0) and initially move in the left-to-right direction (i.e., towards the right).

// While traversing the matrix, follow these rules:

// If the current cell contains 0, continue moving in the same direction.
// If the current cell contains 1, change your direction to the right (clockwise turn), and update the cell value to 0.
// You continue this process until you move outside the boundaries of the matrix. Your task is to determine the coordinates (row and column index) of the cell from which you exit the matrix.
public class ExitPointOfMatrix {
    public static List<Integer>  findExitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0; // Start moving right
        int row = 0, col = 0;

        while (row >= 0 && row < n && col >= 0 && col < m) {
            if (mat[row][col] == 1) {
                // Change direction to the right (clockwise turn)
                dirIndex = (dirIndex + 1) % 4;
                // Update the cell value to 0
                mat[row][col] = 0;
            }
            // Move in the current direction
            row += directions[dirIndex][0];
            col += directions[dirIndex][1];
        }

        // Return the last valid position before exiting the matrix
        return Arrays.asList(row - directions[dirIndex][0], col - directions[dirIndex][1]);
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 0, 0}
        };
        List<Integer> exitPoint = findExitPoint(mat);
        System.out.println("Exit Point: (" + exitPoint.get(0) + ", " + exitPoint.get(1) + ")");
    }
}