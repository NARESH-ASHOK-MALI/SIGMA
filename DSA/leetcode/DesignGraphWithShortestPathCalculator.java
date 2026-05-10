// There is a directed weighted graph that consists of n nodes numbered from 0 to n - 1. The edges of the graph are initially represented by the given array edges where edges[i] = [fromi, toi, edgeCosti] meaning that there is an edge from fromi to toi with the cost edgeCosti.

// Implement the Graph class:

// Graph(int n, int[][] edges) initializes the object with n nodes and the given edges.
// addEdge(int[] edge) adds an edge to the list of edges where edge = [from, to, edgeCost]. It is guaranteed that there is no edge between the two nodes before adding this one.
// int shortestPath(int node1, int node2) returns the minimum cost of a path from node1 to node2. If no path exists, return -1. The cost of a path is the sum of the costs of the edges in the path.
public class DesignGraphWithShortestPathCalculator {
    public class Graph {
        private Map<Integer, List<int[]>> graph;

        public Graph(int n, int[][] edges) {
            graph = new HashMap<>();
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            }
        }

        public void addEdge(int[] edge) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        public int shortestPath(int node1, int node2) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{node1, 0});
            Map<Integer, Integer> dist = new HashMap<>();

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int node = current[0];
                int time = current[1];

                if (dist.containsKey(node)) continue;
                dist.put(node, time);

                if (graph.containsKey(node)) {
                    for (int[] neighbor : graph.get(node)) {
                        if (!dist.containsKey(neighbor[0])) {
                            pq.offer(new int[]{neighbor[0], time + neighbor[1]});
                        }
                    }
                }
            }

            return dist.getOrDefault(node2, -1);
        }
    }
}
