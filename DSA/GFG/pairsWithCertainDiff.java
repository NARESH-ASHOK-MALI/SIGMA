// Given an array of integers and a number k, the task is the find maximum pair sum with the following conditions on the pairs.

// Pair difference should be less than k.
// Pairs should be disjoint. For example if (x, y) is a result pair, then neither x nor y should appear in any other result pair.
// Sum of p pairs means sum of 2p elements in the result.
// If no valid pairs can be formed, return 0.
public class pairsWithCertainDiff{
    public static int maxPairSum(int[] arr, int k) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] - arr[i - 1] < k) {
                sum += arr[i] + arr[i - 1];
                i--; // Skip the next element as it's already paired
            }
        }
        return sum;
    }
}