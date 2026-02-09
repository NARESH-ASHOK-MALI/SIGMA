// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.
public class search_in_Rotated_Sorted_Array33 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine which side is properly sorted
            if (nums[left] <= nums[mid]) { // Left side is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Target is in the left side
                } else {
                    left = mid + 1; // Target is in the right side
                }
            } else { // Right side is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Target is in the right side
                } else {
                    right = mid - 1; // Target is in the left side
                }
            }
        }

        return -1; // Target not found
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int result = search(nums, target);
        System.out.println("Index of target " + target + ": " + result);
    }
}
