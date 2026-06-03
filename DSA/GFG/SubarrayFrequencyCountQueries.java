// Given an array arr[] of n integers and a 2D array queries[][] representing q queries, where each queries[i] consists of three integers: l, r, and x. For each query determine how many times the element x appears in the arr[] from index l to r (both inclusive).

// Return a list of integers where the i-th value represents the answer to the i-th query.
import java.util.*;

class SubarrayFrequencyCountQueries{
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> pos = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            pos.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int x = query[2];

            ArrayList<Integer> list = pos.get(x);
            if (list == null) {
                result.add(0);
                continue;
            }

            int leftIdx = Collections.binarySearch(list, l);
            if (leftIdx < 0) leftIdx = -leftIdx - 1;

            int rightIdx = Collections.binarySearch(list, r);
            if (rightIdx < 0) rightIdx = -rightIdx - 2;

            int count = rightIdx - leftIdx + 1;
            result.add(Math.max(0, count));
        }

        return result;
    }
}