// You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

// We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
public class networkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});
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

        if (dist.size() != n) return -1;
        return Collections.max(dist.values());
    }
}
