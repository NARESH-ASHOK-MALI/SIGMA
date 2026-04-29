
// Given an integer array nums, return the number of reverse pairs in the array.

// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].
 
public class reversePairs {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }
    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        Arrays.sort(nums, left, right + 1);
        return count;
    }
}
