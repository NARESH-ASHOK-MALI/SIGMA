public class tilingprob {
    public static void main(String[] args) {
        int n = 4; // Change this value to test with different sizes of the floor
        int result = countWays(n);
        System.out.println("Number of ways to tile a 2 x " + n + " floor: " + result);
    }
    public static int countWays(int n) {
        if (n == 0||n==1) {
            return 1; // Base case: There is one way to tile a 2 x 0 floor (do nothing)
        }
        if (n < 0) {
            return 0; // Base case: No way to tile a negative length floor
        }
        // Recursive case: Place a vertical tile or place two horizontal tiles
        return countWays(n - 1) + countWays(n - 2);
    }
}
