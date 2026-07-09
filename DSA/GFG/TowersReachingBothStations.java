// Given a matrix mat[][] of size n x m, where mat[i][j] represents the signal strength of a communication tower. Two control stations monitor the network:

// Station P covers the top and left boundaries of the grid.
// Station Q covers the bottom and right boundaries of the grid.
// A signal can propagate from a tower to one of its neighbouring towers in the four directions (North, South, East, and West) only if the neighbouring tower has a signal strength less than or equal to that of the current tower.

// Determine the number of towers (x, y) from which a signal can eventually reach both Station P and Station Q. Any tower located on a boundary covered by a station can transmit directly to that station.

// Examples:

// Input: mat[][] = [[1, 2, 2, 3, 5], [3, 2, 3, 4, 4], [2, 4, 5, 3, 1], [6, 7, 1, 4, 5], [5, 1, 1, 2, 4]]
// Output: 7
// Explanation: 

// (0, 4) & (4, 0) are part of both P & Q 
// (1, 3) reaches P using (1,3)->(0,3) and Q using (1,3)->(1,4)
// (1, 4) reaches P using (1,4)->(1,3)->(1,2)->(0,2) and it is on Q
// (2, 2) reaches P using (2,2)->(2,1)->(2,0) and Q using (2,2)->(2,3)->(2,4)
// (3, 0) is on P and reaches Q using (3,0)->(4,0)
// (3, 1) reaches P using (3,1)->(3,0) and Q using (3,1)->(4,1)
// Input: mat[][] = [[2, 2], [2, 2]]
// Output: 4
// Explanation: In the following example, all cells allow signals to propagate to both the stations.
// Constraints:
// 1 ≤ n, m ≤ 103
// 1 ≤ mat[i][j] ≤ 103 
public class TowersReachingBothStations{
    public int countTowers(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] canReachP = new boolean[n][m];
        boolean[][] canReachQ = new boolean[n][m];
        
        // Perform DFS for Station P (top and left boundaries)
        for (int i = 0; i < n; i++) {
            dfs(mat, canReachP, i, 0);
        }
        for (int j = 0; j < m; j++) {
            dfs(mat, canReachP, 0, j);
        }
        
        // Perform DFS for Station Q (bottom and right boundaries)
        for (int i = 0; i < n; i++) {
            dfs(mat, canReachQ, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            dfs(mat, canReachQ, n - 1, j);
        }
        
        // Count towers that can reach both stations
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canReachP[i][j] && canReachQ[i][j]) {
                    count++;
                }
            }
        }
        
        return count;
    }
    private void dfs(int[][] mat, boolean[][] canReach, int i, int j) {
        int n = mat.length;
        int m = mat[0].length;
        
        if (canReach[i][j]) {
            return;
        }
        
        canReach[i][j] = true;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && mat[newRow][newCol] >= mat[i][j]) {
                dfs(mat, canReach, newRow, newCol);
            }
        }
    }
}