// Given two integers n and m, and an array arr[][] of size k, where arr[i] = [r, c] represents a blocked cell (1-based indexing) in an n × m grid. Each blocked cell blocks its entire row and column. Find the largest continuous unblocked area in the grid.

// Note: No two blocked cells are in the same row or the same column.
// Examples:

// Input: n = 5, m = 5, arr[][] = [[2, 3], [5, 1]]
// Output: 4
// Explanation:
// - Blocked cells (2, 3) and (5, 1) block rows 2, 5 and columns 1, 3.
// - The longest unblocked row segment has length 2 (rows 3–4).
// - The longest unblocked column segment has length 2 (columns 4–5).
// - Therefore, the largest unblocked rectangle has area 2 × 2 = 4.
// Input: n = 2, m = 2, arr[][] = [[2, 2]]
// Output: 1
// Explanation: Since only (1,1) cell is free from the enemy hence answer is 1.
// Constraints:
// 1 ≤ n, m ≤ 104
// 0 ≤ k ≤ min(n, m)
// 1 ≤ r ≤ n
// 1 ≤ c ≤ m
import java.util.HashSet;
import java.util.Set;

public class LargestUnblockedArea {
    public static int largestUnblockedArea(int n, int m, int[][] arr) {
        Set<Integer> blockedRows = new HashSet<>();
        Set<Integer> blockedCols = new HashSet<>();

        for (int[] cell : arr) {
            blockedRows.add(cell[0]);
            blockedCols.add(cell[1]);
        }

        int maxRowSpan = longestFreeSpan(n, blockedRows);
        int maxColSpan = longestFreeSpan(m, blockedCols);

        return maxRowSpan * maxColSpan;
    }

    private static int longestFreeSpan(int size, Set<Integer> blocked) {
        int[] blockedPositions = new int[blocked.size() + 2];
        int index = 0;
        blockedPositions[index++] = 0;

        for (int value : blocked) {
            blockedPositions[index++] = value;
        }

        blockedPositions[index] = size + 1;
        java.util.Arrays.sort(blockedPositions);

        int longest = 0;
        for (int i = 1; i < blockedPositions.length; i++) {
            longest = Math.max(longest, blockedPositions[i] - blockedPositions[i - 1] - 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        int n1 = 5, m1 = 5;
        int[][] arr1 = {{2, 3}, {5, 1}};
        System.out.println(largestUnblockedArea(n1, m1, arr1)); // Output: 4

        int n2 = 2, m2 = 2;
        int[][] arr2 = {{2, 2}};
        System.out.println(largestUnblockedArea(n2, m2, arr2)); // Output: 1
    }
}