// You are given an integer array nums and an integer target.

// Return the number of subarrays of nums in which target is the majority element.

// The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.

 

// Example 1:

// Input: nums = [1,2,2,3], target = 2

// Output: 5

// Explanation:

// Valid subarrays with target = 2 as the majority element:

// nums[1..1] = [2]
// nums[2..2] = [2]
// nums[1..2] = [2,2]
// nums[0..2] = [1,2,2]
// nums[1..3] = [2,2,3]
// So there are 5 such subarrays.

// Example 2:

// Input: nums = [1,1,1,1], target = 1

// Output: 10

// Explanation:

// ​​​​​​​All 10 subarrays have 1 as the majority element.

// Example 3:

// Input: nums = [1,2,3], target = 4

// Output: 0

// Explanation:

// target = 4 does not appear in nums at all. Therefore, there cannot be any subarray where 4 is the majority element. Hence the answer is 0.

 

// Constraints:

// 1 <= nums.length <= 10​​​​​​​5
// 1 <= nums[i] <= 10​​​​​​​9
// 1 <= target <= 109
public class countSubarraysWithMajorityElementII3739{
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        long[] temp = new long[n + 1];
        return countPositivePairs(prefix, temp, 0, n);
    }

    private long countPositivePairs(long[] prefix, long[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        long count = countPositivePairs(prefix, temp, left, mid)
                + countPositivePairs(prefix, temp, mid + 1, right);

        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && prefix[j] <= prefix[i]) {
                j++;
            }
            count += right - j + 1;
        }

        int i = left;
        j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (prefix[i] <= prefix[j]) {
                temp[k++] = prefix[i++];
            } else {
                temp[k++] = prefix[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = prefix[i++];
        }

        while (j <= right) {
            temp[k++] = prefix[j++];
        }

        for (int idx = left; idx <= right; idx++) {
            prefix[idx] = temp[idx];
        }

        return count;
    }
}