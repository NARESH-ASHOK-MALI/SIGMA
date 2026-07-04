// You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.

// The score of a path between two cities is defined as the minimum distance of a road in this path.

// Return the minimum possible score of a path between cities 1 and n.

// Note:

// A path is a sequence of roads between two cities.
// It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
// The test cases are generated such that there is at least one path between 1 and n.
public class MinimumScoreofaPathBetweenTwoCities2492 {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        visited[1] = true;
        int minScore = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            int currentCity = queue.poll();
            
            for (int[] neighbor : graph[currentCity]) {
                minScore = Math.min(minScore, neighbor[1]);
                if (!visited[neighbor[0]]) {
                    visited[neighbor[0]] = true;
                    queue.offer(neighbor[0]);
                }
            }
        }
        
        return minScore;
    }
}
