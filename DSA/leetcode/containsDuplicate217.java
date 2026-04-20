public class containsDuplicate217 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        boolean hasDuplicate = containsDuplicate(nums);
        System.out.println("Contains duplicate: " + hasDuplicate);
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}