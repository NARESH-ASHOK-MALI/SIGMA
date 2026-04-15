public class shortestDistanceToTarget2515 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        int[] result = shortestToTarget(nums, target);
        System.out.println("Shortest distances to target " + target + ": " + java.util.Arrays.toString(result));
    }
    public static int[] shortestToTarget(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[n];
        java.util.Arrays.fill(result, Integer.MAX_VALUE);

        // First pass: left to right
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                result[i] = 0;
            } else if (i > 0 && result[i - 1] != Integer.MAX_VALUE) {
                result[i] = Math.min(result[i], result[i - 1] + 1);
            }
        }

        // Second pass: right to left
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == target) {
                result[i] = 0;
            } else if (i < n - 1 && result[i + 1] != Integer.MAX_VALUE) {
                result[i] = Math.min(result[i], result[i + 1] + 1);
            }
        }

        return result;
    }
}
