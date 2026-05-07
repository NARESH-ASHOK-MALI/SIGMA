// There is an undirected graph with n nodes numbered from 0 to n - 1 (inclusive). You are given a 0-indexed integer array values where values[i] is the value of the ith node. You are also given a 0-indexed 2D integer array edges, where each edges[j] = [uj, vj, timej] indicates that there is an undirected edge between the nodes uj and vj, and it takes timej seconds to travel between the two nodes. Finally, you are given an integer maxTime.

// A valid path in the graph is any path that starts at node 0, ends at node 0, and takes at most maxTime seconds to complete. You may visit the same node multiple times. The quality of a valid path is the sum of the values of the unique nodes visited in the path (each node's value is added at most once to the sum).

// Return the maximum quality of a valid path.

// Note: There are at most four edges connected to each node.
import java.util.ArrayList;
import java.util.List;

public class maximumPathQualityOfGraph {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        // Build the graph as an adjacency list
        int n = values.length;
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }   
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], time = edge[2];
            graph[u].add(new int[]{v, time});
            graph[v].add(new int[]{u, time});
        }

        int[] maxQuality = new int[1];
        int[] visits = new int[n];
        visits[0] = 1;
        
        dfs(0, 0, values[0], visits, graph, values, maxTime, maxQuality);
        return maxQuality[0];
    }

    private void dfs(int node, int currentTime, int currentQuality, int[] visits, List<int[]>[] graph, int[] values, int maxTime, int[] maxQuality) {
        if (node == 0) {
            maxQuality[0] = Math.max(maxQuality[0], currentQuality);
        }

        for (int[] neighbor : graph[node]) {
            int nextNode = neighbor[0];
            int travelTime = neighbor[1];
            
            if (currentTime + travelTime <= maxTime) {
                int nextQuality = currentQuality;
                if (visits[nextNode] == 0) {
                    nextQuality += values[nextNode];
                }
                
                visits[nextNode]++;
                dfs(nextNode, currentTime + travelTime, nextQuality, visits, graph, values, maxTime, maxQuality);
                visits[nextNode]--; // Backtrack visit count
            }
        }
    }
}
