// Given an integer array arr[] and an integer target, determine whether there exists a pair of elements in the array whose product is equal to target.

// Return true if such a pair exists; otherwise, return false.
import java.util.Set;
import java.util.HashSet;

public class productpair {
    public boolean isProduct(int[] arr, long target) {
        // code here
        if (arr == null || arr.length < 2) return false;

        if (target == 0L) {
            int zeroCount = 0;
            for (int num : arr) {
                if (num == 0) zeroCount++;
            }
            return zeroCount >= 1 && arr.length >= 2;
        }

        Set<Long> seen = new HashSet<>();
        for (int num : arr) {
            long nl = num;
            if (nl != 0L && target % nl == 0L) {
                long need = target / nl;
                if (seen.contains(need)) return true;
            }
            seen.add(nl);
        }
        return false;
    }
}
