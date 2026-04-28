public class minOperations2033 {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] <= nums[i - 1]) {
                nums[i] *= 2;
                count++;
            }
        }
        return count;
    }
}
