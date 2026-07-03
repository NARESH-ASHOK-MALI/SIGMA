// You are given a directed acyclic graph of n nodes numbered from 0 to n − 1. This is represented by a 2D array edges of length m, where edges[i] = [ui, vi, costi] indicates a one‑way communication from node ui to node vi with a recovery cost of costi.

// Some nodes may be offline. You are given a boolean array online where online[i] = true means node i is online. Nodes 0 and n − 1 are always online.

// A path from 0 to n − 1 is valid if:

// All intermediate nodes on the path are online.
// The total recovery cost of all edges on the path does not exceed k.
// For each valid path, define its score as the minimum edge‑cost along that path.

// Return the maximum path score (i.e., the largest minimum-edge cost) among all valid paths. If no valid path exists, return -1.

 

// Example 1:

// Input: edges = [[0,1,5],[1,3,10],[0,2,3],[2,3,4]], online = [true,true,true,true], k = 10

// Output: 3
// Example 2:

// Input: edges = [[0,1,7],[1,4,5],[0,2,6],[2,3,6],[3,4,2],[2,4,6]], online = [true,true,true,false,true], k = 12

// Output: 6

// Constraints:

// n == online.length
// 2 <= n <= 5 * 104
// 0 <= m == edges.length <= min(105, n * (n - 1) / 2)
// edges[i] = [ui, vi, costi]
// 0 <= ui, vi < n
// ui != vi
// 0 <= costi <= 109
// 0 <= k <= 5 * 1013
// online[i] is either true or false, and both online[0] and online[n − 1] are true.
// The given graph is a directed acyclic graph.
public class NetworkRecoveryPathWays3620{
    public int maximumPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int left = 0, right = (int) 1e9, answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canReachWithMinEdgeCost(graph, online, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    private boolean canReachWithMinEdgeCost(List<int[]>[] graph, boolean[] online, long k, int minEdgeCost) {
        int n = online.length;
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0}); // {distance, node}

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currDist = curr[0];
            int node = (int) curr[1];

            if (currDist > dist[node]) continue; // Skip if we've found a better path

            for (int[] edge : graph[node]) {
                int nextNode = edge[0];
                int cost = edge[1];
                if (cost >= minEdgeCost && online[nextNode]) {
                    long newDist = dist[node] + cost;
                    if (newDist < dist[nextNode]) {
                        dist[nextNode] = newDist;
                        pq.offer(new long[]{newDist, nextNode});
                    }
                }
            }
        }
        return dist[n - 1] <= k;
    }
}