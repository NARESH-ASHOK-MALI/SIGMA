// Given a binary matrix mat[][] containing only 0s and 1s, find the total coverage of all 0's. The coverage of a particular 0 cell is defined by checking 1's in its four directions (left, right, up, and down). For each direction, if there is at least one 1 anywhere between the 0 and the boundary of the matrix, the coverage increases by one.

// Return the sum of the coverage values for all 0 cells in the matrix.
public class CoverageofallZerosinaBinaryMatrix{
    public int totalCoverage(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int totalCoverage = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    totalCoverage += calculateCoverage(mat, i, j);
                }
            }
        }

        return totalCoverage;
    }
    private int calculateCoverage(int[][] mat, int x, int y) {
        int coverage = 0;
        int m = mat.length;
        int n = mat[0].length;

        // Check left
        for (int j = y - 1; j >= 0; j--) {
            if (mat[x][j] == 1) {
                coverage++;
                break;
            }
        }

        // Check right
        for (int j = y + 1; j < n; j++) {
            if (mat[x][j] == 1) {
                coverage++;
                break;
            }
        }

        // Check up
        for (int i = x - 1; i >= 0; i--) {
            if (mat[i][y] == 1) {
                coverage++;
                break;
            }
        }

        // Check down
        for (int i = x + 1; i < m; i++) {
            if (mat[i][y] == 1) {
                coverage++;
                break;
            }
        }

        return coverage;
    }
}