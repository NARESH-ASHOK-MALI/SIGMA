public class dissappearedNumsInArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        java.util.List<Integer> result = findDisappearedNumbers(nums);
        System.out.println("Disappeared numbers: " + result);
    }
    public static java.util.List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        java.util.List<Integer> result = new java.util.ArrayList<>();

        // Mark the presence of numbers in the array
        for (int num : nums) {
            int index = Math.abs(num) - 1; // Get the index corresponding to the number
            if (nums[index] > 0) { // Mark as negative to indicate presence
                nums[index] = -nums[index];
            }
        }

        // Collect the numbers that are missing (those that are still positive)
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // Add the missing number (index + 1)
            }
        }

        return result;
    }
}
