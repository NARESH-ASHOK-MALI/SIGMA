// Given two integers, start and end, along with an array of integers arr[]. In one operation, you can multiply the current value by any element from arr[], and then take the result modulo 1000 to obtain a new value.

// Find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.
public class minimumMultipliacationToReachEnd {
    public int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) {
            return 0; // No steps needed if start and end are the same
        }

        boolean[] visited = new boolean[1000]; // To track visited values
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++; // Increment steps for each level of BFS

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int num : arr) {
                    int nextValue = (current * num) % 1000;

                    if (nextValue == end) {
                        return steps; // Found the target value
                    }

                    if (!visited[nextValue]) {
                        visited[nextValue] = true;
                        queue.offer(nextValue);
                    }
                }
            }
        }

        return -1; // If we exhaust the queue without finding end
    }
}
