import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

// There is an undirected tree with n nodes labeled from 1 to n, rooted at node 1. The tree is represented by a 2D integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi.

// Initially, all edges have a weight of 0. You must assign each edge a weight of either 1 or 2.

// The cost of a path between any two nodes u and v is the total weight of all edges in the path connecting them.

// You are given a 2D integer array queries. For each queries[i] = [ui, vi], determine the number of ways to assign weights to edges in the path such that the cost of the path between ui and vi is odd.

// Return an array answer, where answer[i] is the number of valid assignments for queries[i].

// Since the answer may be large, apply modulo 109 + 7 to each answer[i].

// Note: For each query, disregard all edges not in the path between node ui and vi.
public class numbersOfWaysToAssignEdgeWeightsII3559 {
    private static final int MOD = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] depth = new int[n];
        int log = 1;
        while ((1 << log) <= n) {
            log++;
        }
        int[][] up = new int[log][n];
        for (int[] row : up) {
            Arrays.fill(row, -1);
        }

        buildDepthAndParents(tree, depth, up);

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0] - 1;
            int v = queries[i][1] - 1;
            int pathLength = getPathLength(u, v, depth, up);
            answer[i] = pathLength == 0 ? 0 : modPow(2, pathLength - 1);
        }
        return answer;
    }

    private void buildDepthAndParents(List<List<Integer>> tree, int[] depth, int[][] up) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        boolean[] visited = new boolean[depth.length];
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : tree.get(node)) {
                if (visited[neighbor]) {
                    continue;
                }
                visited[neighbor] = true;
                depth[neighbor] = depth[node] + 1;
                up[0][neighbor] = node;
                queue.offer(neighbor);
            }
        }

        for (int level = 1; level < up.length; level++) {
            for (int node = 0; node < depth.length; node++) {
                int mid = up[level - 1][node];
                up[level][node] = mid == -1 ? -1 : up[level - 1][mid];
            }
        }
    }

    private int getPathLength(int u, int v, int[] depth, int[][] up) {
        int lca = getLca(u, v, depth, up);
        return depth[u] + depth[v] - 2 * depth[lca];
    }

    private int getLca(int u, int v, int[] depth, int[][] up) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];
        for (int level = 0; diff > 0; level++) {
            if ((diff & 1) == 1) {
                u = up[level][u];
            }
            diff >>= 1;
        }

        if (u == v) {
            return u;
        }

        for (int level = up.length - 1; level >= 0; level--) {
            if (up[level][u] != up[level][v]) {
                u = up[level][u];
                v = up[level][v];
            }
        }
        return up[0][u];
    }

    private int modPow(int base, int exponent) {
        long result = 1;
        long value = base;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * value) % MOD;
            }
            value = (value * value) % MOD;
            exponent >>= 1;
        }
        return (int) result;
    }
}