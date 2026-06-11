// There is an undirected tree with n nodes labeled from 1 to n, rooted at node 1. The tree is represented by a 2D integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi.

// Initially, all edges have a weight of 0. You must assign each edge a weight of either 1 or 2.

// The cost of a path between any two nodes u and v is the total weight of all edges in the path connecting them.

// Select any one node x at the maximum depth. Return the number of ways to assign edge weights in the path from node 1 to x such that its total cost is odd.

// Since the answer may be large, return it modulo 10^9 + 7.

// Note: Ignore all edges not in the path from node 1 to x.
import java.util.*;

public class numbersOfWaysToAssignEdgeWeightsI3558{
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }
        boolean[] visited = new boolean[n];
        int maxDepth = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, depth + 1});
                }
            }
        }
        return pow2(Math.max(0, maxDepth - 1));
    }

    private int pow2(int exponent) {
        long result = 1;
        long base = 2;
        int mod = 1_000_000_007;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }

        return (int) result;
    }
}