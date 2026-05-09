// You are given an m x n integer matrix grid​​​, where m and n are both even integers, and an integer k.

// The matrix is composed of several layers, which is shown in the below image, where each color is its own layer:



// A cyclic rotation of the matrix is done by cyclically rotating each layer in the matrix. To cyclically rotate a layer once, each element in the layer will take the place of the adjacent element in the counter-clockwise direction. An example rotation is shown below:


// Return the matrix after applying k cyclic rotations to it.
public class CyclicallyRotatingaGrid1914 {
    public static void main(String [] args){
        int [][] grid = {{40,10},{30,20}};
        int k = 1;
        int [][] ans = rotateGrid(grid, k);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            // Calculate the number of elements in the current layer
            int numElements = 2 * (bottom - top + right - left);
            int effectiveK = k % numElements; // Effective rotations

            // Extract the elements of the current layer into a list
            int[] temp = new int[numElements];
            int index = 0;

            // Top row
            for (int j = left; j <= right; j++) {
                temp[index++] = grid[top][j];
            }
            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                temp[index++] = grid[i][right];
            }
            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                temp[index++] = grid[bottom][j];
            }
            // Left column
            for (int i = bottom - 1; i > top; i--) {
                temp[index++] = grid[i][left];
            }

            // Rotate the elements in the temp array
            int[] rotatedTemp = new int[numElements];
            for (int i = 0; i < numElements; i++) {
                rotatedTemp[i] = temp[(i + effectiveK) % numElements];
            }

            // Place the rotated elements back into the grid
            index = 0;
            // Top row
            for (int j = left; j <= right; j++) {
                grid[top][j] = rotatedTemp[index++];
            }
            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                grid[i][right] = rotatedTemp[index++];
            }
            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                grid[bottom][j] = rotatedTemp[index++];
            }
            // Left column
            for (int i = bottom - 1;i > top; i--) {
                    grid[i][left] = rotatedTemp[index++];
            }
        }
        return grid;
    }

}
