// You are given an integer array nums of length n and an integer k.

// You need to choose exactly k non-empty subarrays nums[l..r] of nums. Subarrays may overlap, and the exact same subarray (same l and r) can be chosen more than once.

// The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).

// The total value is the sum of the values of all chosen subarrays.

// Return the maximum possible total value you can achieve.
public class maxTotalSubArrayValueI3689{
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k <= 0) return 0L;

        // The maximum possible subarray value equals global max - global min
        int globalMin = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < globalMin) globalMin = nums[i];
            if (nums[i] > globalMax) globalMax = nums[i];
        }

        return (long) (globalMax - globalMin) * k;
    }
}