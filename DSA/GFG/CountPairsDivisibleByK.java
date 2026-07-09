// Given an array arr[] and positive integer k, count total number of pairs in the array whose sum is divisible by k.

// Examples:

// Input :  arr[] = [2, 2, 1, 7, 5, 3], k = 4
// Output : 5
// Explanation : There are five pairs possible whose sum is divisible by '4' i.e., (2, 2), (1, 7), (7, 5), (1, 3) and (5, 3).
// Input : arr[] = [5, 9, 36, 74, 52, 31, 42], k = 3
// Output : 7 
// Explanation : There are seven pairs whose sum is divisible by 3, i.e, (9, 36), (9,42), (74, 52), (36, 42), (74, 31), (31, 5) and (5, 52).
// Constraints :
// 1 ≤ |arr| ≤ 5*104
// 1 ≤ arr[i] ≤ 106
// 1 ≤ k ≤ 5*104
public class CountPairsDivisibleByK {
    public static int countPairs(int[] arr, int k) {
        int[] remainderCount = new int[k];
        int count = 0;

        // Count occurrences of each remainder when divided by k
        for (int num : arr) {
            remainderCount[num % k]++;
        }

        // Count pairs with remainder 0
        count += (remainderCount[0] * (remainderCount[0] - 1)) / 2;

        // Count pairs with remainders i and k-i
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                count += remainderCount[i] * remainderCount[k - i];
            }
        }

        // If k is even, count pairs with remainder k/2
        if (k % 2 == 0) {
            count += (remainderCount[k / 2] * (remainderCount[k / 2] - 1)) / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 1, 7, 5, 3};
        int k1 = 4;
        System.out.println("Output: " + countPairs(arr1, k1)); // Output: 5

        int[] arr2 = {5, 9, 36, 74, 52, 31, 42};
        int k2 = 3;
        System.out.println("Output: " + countPairs(arr2, k2)); // Output: 7
    }
}