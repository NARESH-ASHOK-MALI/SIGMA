// You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

// You are given two arrays redEdges and blueEdges where:

// redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
// blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
// Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.
import java.util.*;

public class shortestpathwithAlternatingColors {
    public static void main(String [] args){
        int n = 3;
        int [][] redEdges = {{0,1},{1,2}};
        int [][] blueEdges = {};
        int [] ans = shortestAlternatingPaths(n, redEdges, blueEdges);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redGraph = new ArrayList<>();
        List<List<Integer>> blueGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            redGraph.add(new ArrayList<>());
            blueGraph.add(new ArrayList<>());
        }

        for (int[] edge : redEdges) {
            redGraph.get(edge[0]).add(edge[1]);
        }

        for (int[] edge : blueEdges) {
            blueGraph.get(edge[0]).add(edge[1]);
        }

        int[][] dist = new int[n][2];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }
        dist[0][0] = 0;
        dist[0][1] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // {node, steps, color}
        queue.offer(new int[]{0, 0, 1}); 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int steps = current[1];
            int color = current[2];
            List<List<Integer>> graph = (color == 0) ? blueGraph : redGraph;
            int nextColor = 1 - color;

            for (int neighbor : graph.get(node)) {
                if (dist[neighbor][nextColor] == -1) {
                    dist[neighbor][nextColor] = steps + 1;
                    queue.offer(new int[]{neighbor, steps + 1, nextColor});
                }
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i][0] != -1 && dist[i][1] != -1) {
                answer[i] = Math.min(dist[i][0], dist[i][1]);
            } else if (dist[i][0] != -1) {
                answer[i] = dist[i][0];
            } else {
                answer[i] = dist[i][1];
            }
        }

        return answer;
    }
}
