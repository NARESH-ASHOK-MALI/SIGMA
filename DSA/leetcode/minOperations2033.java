// You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.

// A uni-value grid is a grid where all the elements of it are equal.

// Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.
public class minOperations2033 {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        int median = list.get(list.size() / 2);
        int count = 0;
        for (int num : list) {
            if (Math.abs(num - median) % x != 0) {
                return -1;
            }
            count += Math.abs(num - median) / x;
        }
        return count;
    }
}
