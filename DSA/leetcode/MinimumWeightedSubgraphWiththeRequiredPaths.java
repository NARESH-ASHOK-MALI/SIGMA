// You are given an integer n denoting the number of nodes of a weighted directed graph. The nodes are numbered from 0 to n - 1.

// You are also given a 2D integer array edges where edges[i] = [fromi, toi, weighti] denotes that there exists a directed edge from fromi to toi with weight weighti.

// Lastly, you are given three distinct integers src1, src2, and dest denoting three distinct nodes of the graph.

// Return the minimum weight of a subgraph of the graph such that it is possible to reach dest from both src1 and src2 via a set of edges of this subgraph. In case such a subgraph does not exist, return -1.

// A subgraph is a graph whose vertices and edges are subsets of the original graph. The weight of a subgraph is the sum of weights of its constituent edges.
public class MinimumWeightedSubgraphWiththeRequiredPaths {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        Map<Integer, List<int[]>> reverseGraph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            reverseGraph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }

        long[] distFromSrc1 = dijkstra(graph, src1, n);
        long[] distFromSrc2 = dijkstra(graph, src2, n);
        long[] distToDest = dijkstra(reverseGraph, dest, n);

        long minWeight = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (distFromSrc1[i] != Long.MAX_VALUE && distFromSrc2[i] != Long.MAX_VALUE && distToDest[i] != Long.MAX_VALUE) {
                minWeight = Math.min(minWeight, distFromSrc1[i] + distFromSrc2[i] + distToDest[i]);
            }
        }

        return minWeight == Long.MAX_VALUE ? -1 : minWeight;
    }
    private long[] dijkstra(Map<Integer, List<int[]>> graph, int start, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            long currentDist = current[1];

            if (currentDist > dist[node]) continue;

            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    long weight = neighbor[1];
                    if (dist[node] + weight < dist[nextNode]) {
                        dist[nextNode] = dist[node] + weight;
                        pq.offer(new int[]{nextNode, (int) dist[nextNode]});
                    }
                }
            }
        }

        return dist;
    }
}
