public class numSmallerThanCurrentNum {
    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        int[] result = smallerNumbersThanCurrent(nums);
        System.out.println("Output: " + java.util.Arrays.toString(result));
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] count = new int[101]; // Since the problem states that 0 <= nums[i] <= 100
        int[] result = new int[n];

        // Count the frequency of each number in the input array
        for (int num : nums) {
            count[num]++;
        }

        // Calculate the cumulative count to determine how many numbers are smaller than each number
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Fill the result array based on the cumulative counts
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0; // No numbers are smaller than 0
            } else {
                result[i] = count[nums[i] - 1]; // The count of numbers smaller than nums[i]
            }
        }

        return result;
    }
}
