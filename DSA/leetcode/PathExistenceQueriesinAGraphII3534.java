// You are given an integer n representing the number of nodes in a graph, labeled from 0 to n - 1.

// You are also given an integer array nums of length n and an integer maxDiff.

// An undirected edge exists between nodes i and j if the absolute difference between nums[i] and nums[j] is at most maxDiff (i.e., |nums[i] - nums[j]| <= maxDiff).

// You are also given a 2D integer array queries. For each queries[i] = [ui, vi], find the minimum distance between nodes ui and vi. If no path exists between the two nodes, return -1 for that query.

// Return an array answer, where answer[i] is the result of the ith query.

// Note: The edges between the nodes are unweighted.

 

// Example 1:

// Input: n = 5, nums = [1,8,3,4,2], maxDiff = 3, queries = [[0,3],[2,4]]

// Output: [1,1]

// Explanation:

// The resulting graph is:



// Query	Shortest Path	Minimum Distance
// [0, 3]	0 → 3	1
// [2, 4]	2 → 4	1
// Thus, the output is [1, 1].

// Example 2:

// Input: n = 5, nums = [5,3,1,9,10], maxDiff = 2, queries = [[0,1],[0,2],[2,3],[4,3]]

// Output: [1,2,-1,1]

// Explanation:

// The resulting graph is:



// Query	Shortest Path	Minimum Distance
// [0, 1]	0 → 1	1
// [0, 2]	0 → 1 → 2	2
// [2, 3]	None	-1
// [4, 3]	3 → 4	1
// Thus, the output is [1, 2, -1, 1].

// Example 3:

// Input: n = 3, nums = [3,6,1], maxDiff = 1, queries = [[0,0],[0,1],[1,2]]

// Output: [0,-1,-1]

// Explanation:

// There are no edges between any two nodes because:

// Nodes 0 and 1: |nums[0] - nums[1]| = |3 - 6| = 3 > 1
// Nodes 0 and 2: |nums[0] - nums[2]| = |3 - 1| = 2 > 1
// Nodes 1 and 2: |nums[1] - nums[2]| = |6 - 1| = 5 > 1
// Thus, no node can reach any other node, and the output is [0, -1, -1].

 

import java.util.*;

// Constraints:

// 1 <= n == nums.length <= 105
// 0 <= nums[i] <= 105
// 0 <= maxDiff <= 105
// 1 <= queries.length <= 105
// queries[i] == [ui, vi]
// 0 <= ui, vi < n
public class PathExistenceQueriesinAGraphII3534{
    public int[] minDistance(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] nodes = new int[n][2];
        for (int i = 0; i < n; i++) {
            nodes[i][0] = nums[i];
            nodes[i][1] = i;
        }

        Arrays.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int[] sortedValues = new int[n];
        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            sortedValues[i] = nodes[i][0];
            position[nodes[i][1]] = i;
        }

        int[] component = new int[n];
        for (int i = 1; i < n; i++) {
            component[i] = component[i - 1] + (sortedValues[i] - sortedValues[i - 1] > maxDiff ? 1 : 0);
        }

        int[] next = new int[n];
        int right = 0;
        for (int left = 0; left < n; left++) {
            if (right < left) {
                right = left;
            }
            while (right + 1 < n && sortedValues[right + 1] - sortedValues[left] <= maxDiff) {
                right++;
            }
            next[left] = right;
        }

        int log = 1;
        while ((1 << log) <= n) {
            log++;
        }

        int[][] jump = new int[log][n];
        System.arraycopy(next, 0, jump[0], 0, n);
        for (int k = 1; k < log; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];
            int pu = position[u];
            int pv = position[v];

            if (pu == pv) {
                result[q] = 0;
                continue;
            }

            if (component[pu] != component[pv]) {
                result[q] = -1;
                continue;
            }

            int left = Math.min(pu, pv);
            int target = Math.max(pu, pv);
            int steps = 0;
            int current = left;

            for (int k = log - 1; k >= 0; k--) {
                int farthest = jump[k][current];
                if (farthest < target) {
                    current = farthest;
                    steps += 1 << k;
                }
            }

            result[q] = steps + 1;
        }

        return result;
    }
}