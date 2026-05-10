// You are given a 0-indexed array nums of n integers and an integer target.

// You are initially positioned at index 0. In one step, you can jump from index i to any index j such that:

// 0 <= i < j < n
// -target <= nums[j] - nums[i] <= target
// Return the maximum number of jumps you can make to reach index n - 1.

// If there is no way to reach index n - 1, return -1.

 
public class MaximumNumberofJumpstoReachtheLastIndex2770 {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && Math.abs(nums[i] - nums[j]) <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
