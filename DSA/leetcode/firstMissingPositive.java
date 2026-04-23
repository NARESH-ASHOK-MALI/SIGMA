// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
public class firstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Step 1: Replace all non-positive numbers with a number larger than n
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        
        // Step 2: Use the array itself as a hash table
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        
        // Step 3: Find the first positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        // If all numbers from 1 to n are present, return n + 1
        return n + 1;
    }
}
