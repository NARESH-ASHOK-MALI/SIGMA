//https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations?envType=daily-question&envId=2026-04-21
import java.util.*;

public class minimumHammingDistance1722 {
    public static void main(String[] args) {
        minimumHammingDistance1722 solution = new minimumHammingDistance1722();
        int[] source1 = {1, 2, 3, 4};
        int[] target1 = {2, 1, 4, 5};
        int[][] allowedSwaps1 = {{0, 1}, {2, 3}};
        System.out.println(solution.minimumHammingDistance(source1, target1, allowedSwaps1)); // 1

        int[] source2 = {1, 2, 3};
        int[] target2 = {1, 3, 2};
        int[][] allowedSwaps2 = {{0, 1}, {1, 2}, {0, 2}};
        System.out.println(solution.minimumHammingDistance(source2, target2, allowedSwaps2)); // 0
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);

        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int hammingDistance = 0;
        for (List<Integer> group : groups.values()) {
            Map<Integer, Integer> countSource = new HashMap<>();
            Map<Integer, Integer> countTarget = new HashMap<>();

            for (int index : group) {
                countSource.put(source[index], countSource.getOrDefault(source[index], 0) + 1);
                countTarget.put(target[index], countTarget.getOrDefault(target[index], 0) + 1);
            }

            for (int key : countSource.keySet()) {
                hammingDistance += Math.max(0, countSource.get(key) - countTarget.getOrDefault(key, 0));
            }
        }

        return hammingDistance;
    }

    static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    
}
