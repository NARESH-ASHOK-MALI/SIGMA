// Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

// A good subarray is a subarray where:

// its length is at least two, and
// the sum of the elements of the subarray is a multiple of k.
public class checkSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> modIndexMap = new HashMap<>();
        modIndexMap.put(0, -1); // Handle the case where the subarray starts from index 0
        int cumulativeSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            int mod = cumulativeSum % k;

            if (modIndexMap.containsKey(mod)) {
                if (i - modIndexMap.get(mod) > 1) { // Check if the subarray length is at least 2
                    return true;
                }
            } else {
                modIndexMap.put(mod, i); // Store the first occurrence of this mod value
            }
        }

        return false;
    }
}
