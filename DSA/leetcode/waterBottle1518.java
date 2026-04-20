public class waterBottle1518 {
    public static void main(String[] args) {
        int numBottles = 9;
        int numExchange = 3;
        int totalBottles = numWaterBottles(numBottles, numExchange);
        System.out.println("Total water bottles you can drink: " + totalBottles);
    }
    public static int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunk = numBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange;
            totalDrunk += newBottles;
            emptyBottles = emptyBottles % numExchange + newBottles;
        }

        return totalDrunk;
    }
}
