// Given a array arr[] of positive integers, find the smallest positive integer such that it cannot be represented as the sum of elements of any subset of the given array set.
import java.util.Arrays;

public class NotASubsetSum {
    public int findSmallest(int[] arr) {
        if (arr == null || arr.length == 0) return 1;

        Arrays.sort(arr);

        int res = 1; // Initialize result

        // Traverse the sorted array and increment 'res' if arr[i] is smaller than or equal to 'res'
        for (int i = 0; i < arr.length && arr[i] <= res; i++) {
            res += arr[i];
        }

        return res;
    }
}
