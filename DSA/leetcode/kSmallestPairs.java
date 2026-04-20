import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class kSmallestPairs {
    public static void main(String[] args) {
        // Example input arrays.
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};

        // We only want the first 3 pairs produced by this method.
        int k = 3;
        List<List<Integer>> pairs = kSmallestPairs(nums1, nums2, k);

        // Print each pair in a readable format.
        for (List<Integer> pair : pairs) {
            System.out.println("(" + pair.get(0) + ", " + pair.get(1) + ")");
        }
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Stores the pairs we have collected so far.
        List<List<Integer>> result = new ArrayList<>();

        // If one input is empty or k is not positive, there are no pairs to return.
        if (k <= 0 || nums1.length == 0 || nums2.length == 0) {
            return result;
        }

        // Each heap entry stores: [sum, index in nums1, index in nums2].
        // We only keep the next best candidate for each nums1 value.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Start with the smallest pair for each nums1 element we may need.
        // Because nums2 is sorted, pairing nums1[i] with nums2[0] is the best
        // starting point for that row.
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[] { nums1[i] + nums2[0], i, 0 });
        }

        // Repeatedly take the smallest available pair sum.
        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[1];
            int j = current[2];

            // Add the actual pair values to the answer.
            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Move to the next element in nums2 for the same nums1 value.
            // This keeps the heap focused on the next possible pair from that row.
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
            }
        }

        return result;
    }
}
