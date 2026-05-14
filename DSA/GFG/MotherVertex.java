// Given a directed graph with V vertices labeled from 0 to V-1 and a list of edges edges[][], where each edge is represented as [u, v] indicating a directed edge from vertex u to vertex v, find a Mother Vertex of the graph.

// A Mother Vertex is a vertex from which all other vertices can be reached.

import java.util.ArrayList;
import java.util.Arrays;

    // // If multiple such vertices exist, return the one with the smallest value.
    // If no such vertex exists, return -1.
public class MotherVertex {
    public int findMotherVertex(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            reverseGraph.get(to).add(from);
        }

        boolean[] visited = new boolean[V];
        int motherVertex = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph);
                motherVertex = i;
            }
        }

        Arrays.fill(visited, false);
        dfs(motherVertex, visited, graph);

        for (boolean v : visited) {
            if (!v) {
                return -1;
            }
        }

        Arrays.fill(visited, false);
        dfs(motherVertex, visited, reverseGraph);

        int answer = motherVertex;
        for (int i = 0; i < V; i++) {
            if (visited[i]) {
                answer = Math.min(answer, i);
            }
        }

        return answer;
    }   
    public void dfs(int vertex, boolean[] visited, ArrayList<ArrayList<Integer>> edges) {
        visited[vertex] = true;
        for (int neighbor : edges.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, edges);
            }
        }
    }
}
