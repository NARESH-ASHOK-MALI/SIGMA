// You are given an integer array nums of even length n and an integer limit. In one move, you can replace any integer from nums with another integer between 1 and limit, inclusive.

// The array nums is complementary if for all indices i (0-indexed), nums[i] + nums[n - 1 - i] equals the same number. For example, the array [1,2,3,4] is complementary because for all indices i, nums[i] + nums[n - 1 - i] = 5.

// Return the minimum number of moves required to make nums complementary.

public class MinimumMovestoMakeArrayComplementary1674 {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            int sum = a + b;

            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            diff[low] -= 1;
            diff[high + 1] += 1;

            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 2; i <= 2 * limit; i++) {
            ans = Math.min(ans, diff[i]);
        }
        return ans;
    }
}