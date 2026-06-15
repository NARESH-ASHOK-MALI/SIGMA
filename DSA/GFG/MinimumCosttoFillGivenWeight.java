// Given a bag of size w kg and you are provided costs of packets different weights of oranges in array cost[], find the minimum total cost to buy exactly w kg oranges

// The cost of 1 kg orange is present at index 0 and in general arr[i] has cost of (i+1) kg orange.
// cost[i] = -1 means that 'i+1' kg packet of orange is unavailable.
// If it is not possible to buy exactly w kg oranges then return -1. It may be assumed that there is an infinite supply of all available packet types.
public class MinimumCosttoFillGivenWeight{
    public static int minimumCost(int cost[], int w) {
        int[] dp = new int[w + 1];
        for (int i = 1; i <= w; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < cost.length; j++) {
                if (cost[j] != -1 && j + 1 <= i && dp[i - (j + 1)] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], cost[j] + dp[i - (j + 1)]);
                }
            }
        }
        return dp[w] == Integer.MAX_VALUE ? -1 : dp[w];
    }

    public static void main(String[] args) {
        int[] cost = {20, 10, 4, 50, 100};
        int w = 5;
        System.out.println(minimumCost(cost, w)); // Output: 14
    }
}