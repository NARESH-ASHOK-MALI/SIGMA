public class disdonalSum {
    public static void diagonalSum(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i]; //primary diagonal
            if (i != matrix.length - 1 - i) { //to avoid adding the middle element twice in case of odd dimension
                sum += matrix[i][matrix.length - 1 - i]; //secondary diagonal
            }
        }
        System.out.println("Diagonal Sum: " + sum);
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        diagonalSum(matrix);
    }
}
