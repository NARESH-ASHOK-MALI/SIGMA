// It is a sweltering summer day, and a boy wants to buy some ice cream bars.

// At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. 

// Note: The boy can buy the ice cream bars in any order.

// Return the maximum number of ice cream bars the boy can buy with coins coins.

// You must solve the problem by counting sort.
public class MaximumIceCreamBar1833{
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 100000; // Given constraint: 1 <= costs[i] <= 10^5
        int[] count = new int[maxCost + 1];

        // Count the occurrences of each cost
        for (int cost : costs) {
            count[cost]++;
        }

        int totalBars = 0;

        // Iterate through the count array to buy ice cream bars
        for (int price = 1; price <= maxCost; price++) {
            while (count[price] > 0 && coins >= price) {
                coins -= price; // Deduct the cost from coins
                totalBars++;    // Increment the number of bars bought
                count[price]--; // Decrease the count of this price
            }
            if (coins < price) {
                break; // No more coins to buy higher priced bars
            }
        }

        return totalBars;
    }
}