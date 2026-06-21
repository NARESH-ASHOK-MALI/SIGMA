// You are given an integer array nums. A number x is lonely when it appears only once, and no adjacent numbers (i.e. x + 1 and x - 1) appear in the array.

// Return all lonely numbers in nums. You may return the answer in any order.
public class findAllLonelyNumbersIntheArray2150{
public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] + 1 && nums[i] < nums[i + 1] - 1) {
                res.add(nums[i]);
            }
        }

        if (nums.length == 1) {
            res.add(nums[0]);
        }

        if (nums.length > 1) {
            if (nums[0] < nums[1] - 1) {
                res.add(nums[0]);
            }
            if (nums[nums.length - 1] > nums[nums.length - 2] + 1) {
                res.add(nums[nums.length - 1]);
            }
        }

        return res;
    }
}
