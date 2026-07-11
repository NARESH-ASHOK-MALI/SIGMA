// You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

// Return the number of complete connected components of the graph.

// A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

// A connected component is said to be complete if there exists an edge between every pair of its vertices.
public class CounttheNumberofCompleteComponents2685 {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int completeComponents = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Set<Integer> componentVertices = new HashSet<>();
                dfs(graph, i, visited, componentVertices);
                
                int vertexCount = componentVertices.size();
                int edgeCount = 0;
                
                for (int vertex : componentVertices) {
                    edgeCount += graph[vertex].size();
                }
                
                // Each edge is counted twice in an undirected graph
                edgeCount /= 2;
                
                // A complete component with k vertices has k * (k - 1) / 2 edges
                if (edgeCount == vertexCount * (vertexCount - 1) / 2) {
                    completeComponents++;
                }
            }
        }
        
        return completeComponents;
    }
    private void dfs(List<Integer>[] graph, int node, boolean[] visited, Set<Integer> componentVertices) {
        visited[node] = true;
        componentVertices.add(node);
        
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, componentVertices);
            }
        }
    }
}
