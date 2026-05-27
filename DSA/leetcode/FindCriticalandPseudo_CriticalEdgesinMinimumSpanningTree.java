// Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1, and an array edges where edges[i] = [ai, bi, weighti] represents a bidirectional and weighted edge between nodes ai and bi. A minimum spanning tree (MST) is a subset of the graph's edges that connects all vertices without cycles and with the minimum possible total edge weight.

// Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST). An MST edge whose deletion from the graph would cause the MST weight to increase is called a critical edge. On the other hand, a pseudo-critical edge is that which can appear in some MSTs but not all.

// Note that you can return the indices of the edges in any order.
public class FindCriticalandPseudo_CriticalEdgesinMinimumSpanningTree {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();
        // Step 1: Augment edges with original indices and sort by weight
        int m = edges.length;
        int[][] e = new int[m][4];
        for (int i = 0; i < m; i++) {
            e[i][0] = edges[i][0];
            e[i][1] = edges[i][1];
            e[i][2] = edges[i][2];
            e[i][3] = i; // original index
        }
        Arrays.sort(e, Comparator.comparingInt(x -> x[2]));

        // Step 2: Find the weight of the original MST (using sorted augmented edges)
        int originalMSTWeight = kruskal(n, e, -1, -1);

        // Step 3 & 4: For each sorted edge, test critical then pseudo-critical
        for (int i = 0; i < m; i++) {
            // if skipping this edge increases MST weight, it's critical
            if (kruskal(n, e, i, -1) > originalMSTWeight) {
                criticalEdges.add(e[i][3]);
            } else if (kruskal(n, e, -1, i) == originalMSTWeight) {
                // otherwise, if forcing this edge can produce MST with same weight, it's pseudo-critical
                pseudoCriticalEdges.add(e[i][3]);
            }
        }

        result.add(criticalEdges);
        result.add(pseudoCriticalEdges);
        return result;
    }
    private int kruskal(int n, int[][] edges, int skipEdge, int forceEdge) {
        UnionFind uf = new UnionFind(n);
        int totalWeight = 0;

        if (forceEdge != -1) {
            uf.union(edges[forceEdge][0], edges[forceEdge][1]);
            totalWeight += edges[forceEdge][2];
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == skipEdge) continue;
            if (uf.union(edges[i][0], edges[i][1])) {
                totalWeight += edges[i][2];
            }
        }

        return uf.getCount() == 1 ? totalWeight : Integer.MAX_VALUE;
    }
    public class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
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
            if (rootX == rootY) return false;

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            count--;
            return true;
        }

        public int getCount() {
            return count;
        }
    }
}
