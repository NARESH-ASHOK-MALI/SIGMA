public class busRoutes {
    public static void main(String [] args){
        int [][] routes = {{1, 2, 7}, {3, 6, 7}};
        int source = 1;
        int target = 6;
        System.out.println(numBusesToDestination(routes, source, target));
    }
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        queue.offer(source);
        visitedStops.add(source);
        int busesTaken = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            busesTaken++;
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                List<Integer> busesAtStop = stopToBuses.getOrDefault(currentStop, Collections.emptyList());

                for (int bus : busesAtStop) {
                    if (visitedBuses.contains(bus)) continue;
                    visitedBuses.add(bus);

                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return busesTaken;
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
