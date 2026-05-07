// You are given an integer array nums.

// From any index i, you can jump to another index j under the following rules:

// Jump to index j where j > i is allowed only if nums[j] < nums[i].
// Jump to index j where j < i is allowed only if nums[j] > nums[i].
// For each index i, find the maximum value in nums that can be reached by following any sequence of valid jumps starting at i.

// Return an array ans where ans[i] is the maximum value reachable starting from index i.
public class jumpGameIX3660 {
    public int[] maxJumps(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // Stack stores components as: {min, max, startIndex, endIndex}
        java.util.Deque<int[]> stack = new java.util.ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            int start = i;
            int end = i;
            
            while (!stack.isEmpty() && stack.peek()[1] > min) {
                int[] top = stack.pop();
                min = Math.min(min, top[0]);
                max = Math.max(max, top[1]);
                start = top[2]; // merge and extend the start index
            }
            
            stack.push(new int[]{min, max, start, end});
        }
        
        for (int[] comp : stack) {
            int maxVal = comp[1];
            int start = comp[2];
            int end = comp[3];
            for (int i = start; i <= end; i++) {
                ans[i] = maxVal;
            }
        }
        
        return ans;
    }
}
