// Given an array integer arr[] , representing the values of coins arranged in a row.

// Two players play a game by picking coins alternately.
// At each turn, a player can pick a coin from either the beginning or the end of the array. Both players follow a greedy strategy, i.e., they always pick the coin with the maximum value among the two available ends.
// The game continues until only one coin remains.
// Find the value of the last remaining coin.
public class LastCoininaGameofAlternates {
    public static int lastRemainingCoin(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left < right) {
            if (arr[left] >= arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return arr[left]; // or arr[right], both are the same at this point
    }
}
