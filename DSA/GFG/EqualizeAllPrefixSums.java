import java.util.ArrayList;

// Given a sorted array arr[]. For each i(0 ≤ i ≤ n-1), make all the elements of the array from index 0 to i equal, using the minimum number of operations.

// In one operation you either increase or decrease the array element by 1. Return an array that contains the minimum number of operations for each i, to accomplish the above task.

// Note:  

// For each index i, consider the original array without applying modifications made for previous indices.
// Try to solve the problem using O(1) extra space (excluding the resultant array).
public class EqualizeAllPrefixSums{
    public ArrayList<Integer> optimalArray(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        long prefixSum = 0;
        long leftSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            int medianIndex = i / 2;
            if (i == 0) {
                leftSum = prefixSum;
            } else if (i % 2 == 0) {
                leftSum += arr[medianIndex];
            }

            long median = arr[medianIndex];
            long operations = prefixSum - 2L * leftSum + median * (2L * medianIndex + 1 - i);
            result.add((int) operations);
        }

        return result;
    }
}