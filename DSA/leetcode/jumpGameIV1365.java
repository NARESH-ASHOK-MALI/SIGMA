// Given an array of integers arr, you are initially positioned at the first index of the array.

// In one step you can jump from index i to index:

// i + 1 where: i + 1 < arr.length.
// i - 1 where: i - 1 >= 0.
// j where: arr[i] == arr[j] and i != j.
// Return the minimum number of steps to reach the last index of the array.

// Notice that you can not jump outside of the array at any time.
public class jumpGameIV1365 {
    public int minJumps(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;

        int n = arr.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (index == n - 1) return steps;

                // Jump to index + 1
                if (index + 1 < n && !visited[index + 1]) {
                    visited[index + 1] = true;
                    queue.offer(index + 1);
                }

                // Jump to index - 1
                if (index - 1 >= 0 && !visited[index - 1]) {
                    visited[index - 1] = true;
                    queue.offer(index - 1);
                }

                // Jump to indices with the same value
                for (int nextIndex : graph.get(arr[index])) {
                    if (nextIndex != index && !visited[nextIndex]) {
                        visited[nextIndex] = true;
                        queue.offer(nextIndex);
                    }
                }
                // Clear the list to prevent future redundant checks
                graph.get(arr[index]).clear();
            }
            steps++;
        }

        return -1; // If we can't reach the end
    }
    
}
