// You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

// Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
public class minimumCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] edges = new int[n * (n - 1) / 2][3];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges[idx][0] = i;
                edges[idx][1] = j;
                edges[idx][2] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                idx++;
            }
        }
        Arrays.sort(edges, Comparator.comparingInt(x -> x[2]));
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                totalCost += edge[2];
            }
        }
        return totalCost;
    }
    public class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }
}
