// Given two machines, Machine A and Machine B, and a set of n tasks. The profit earned for performing each task is given in two arrays a[] and b[] such that if Machine A performs the i-th task, the profit is a[i], and if Machine B performs it, the profit is b[i].

// Machine A can process at most x tasks, and Machine B can process at most y tasks. It is guaranteed that x + y ≥ n, so all tasks can be assigned. Return the maximum possible profit after assigning each task to either Machine A or Machine B.
import java.util.Arrays;

public class MaxProfitfromTwoMachine {
    public static int maxProfit(int[] a, int[] b, int x, int y) {
        int n = a.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort indices based on a[i] - b[i] in descending order
        Arrays.sort(indices, (i1, i2) -> Integer.compare(a[i2] - b[i2], a[i1] - b[i1]));
        
        int totalProfit = 0;
        
        for (int i = 0; i < n; i++) {
            int index = indices[i];
            // Assign to A if we MUST (because B doesn't have enough capacity for the rest)
            // OR if it's profitable (a > b) AND we haven't exceeded A's capacity (x)
            if (i < n - y || (a[index] - b[index] > 0 && i < x)) {
                totalProfit += a[index];
            } else {
                totalProfit += b[index];
            }
        }
        
        return totalProfit;
    }
}
