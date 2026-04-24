// You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element. Notice that the index of the elements may change after the removal.

// For example, if nums = [6,1,7,4,1]:

// Choosing to remove index 1 results in nums = [6,7,4,1].
// Choosing to remove index 2 results in nums = [6,1,4,1].
// Choosing to remove index 4 results in nums = [6,1,7,4].
// An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.

// Return the number of indices that you could choose such that after the removal, nums is fair.
public class waysToMakeFair {
    public int waysToMakeFair(int[] nums) {
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) evenSum += nums[i];
            else oddSum += nums[i];
        }

        int count = 0;
        int leftOddSum = 0, leftEvenSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) evenSum -= nums[i];
            else oddSum -= nums[i];

            if (leftEvenSum + oddSum == leftOddSum + evenSum) count++;

            if (i % 2 == 0) leftEvenSum += nums[i];
            else leftOddSum += nums[i];
        }

        return count;
    }
}