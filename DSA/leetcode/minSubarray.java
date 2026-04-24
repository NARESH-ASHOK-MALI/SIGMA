// Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.

// Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

// A subarray is defined as a contiguous block of elements in the array.
import java.util.HashMap;
import java.util.Map;
public class minSubarray {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        int p = 6;
        System.out.println(minSubarray(nums, p)); // Output: 1
    }
    public static int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int remainder = (int) (totalSum % p);
        if (remainder == 0) {
            return 0; // No need to remove any subarray
        }

        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1); // To handle the case when the subarray starts from index 0
        int currentRemainder = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentRemainder = (int) (((long) currentRemainder + nums[i]) % p);

            // Check if there is a prefix with the required remainder
            int targetRemainder = (currentRemainder - remainder + p) % p;
            if (prefixMap.containsKey(targetRemainder)) {
                minLength = Math.min(minLength, i - prefixMap.get(targetRemainder));
            }

            // Update the prefix map with the current remainder
            prefixMap.put(currentRemainder, i);
        }

        if (minLength == Integer.MAX_VALUE || minLength == nums.length) {
            return -1;
        }
        return minLength;
    }

}
