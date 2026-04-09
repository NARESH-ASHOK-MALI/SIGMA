// Given a route containing 4 directions (E, W, N, S),
// find the shortest path to reach destination.
// "WNEENESENNN"


public class shortestpath {

    public static void shortestPath(String route) {
        int x = 0, y = 0;
        for (char c : route.toCharArray()) {
            switch (c) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
                default: System.out.println("Invalid direction: " + c);
            }
        }
        System.out.println("Shortest path to destination: (" + x + ", " + y + ")");
         float distance = (float) Math.sqrt(x * x + y * y);
        System.out.println("Shortest distance to destination: " + distance);
    }
    public static void main(String[] args) {
        String route = "NS";
        shortestPath(route);
    }
}
