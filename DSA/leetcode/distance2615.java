// You are given a 0-indexed integer array nums. There exists an array arr of length nums.length, where arr[i] is the sum of |i - j| over all j such that nums[j] == nums[i] and j != i. If there is no such j, set arr[i] to be 0.

// Return the array arr.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class distance2615 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 1, 2};
        long[] result = distance(nums);
        for (long value : result) {
            System.out.print(value + " ");
        }
        // Output: [5, 0, 3, 4, 0]
    }
    public static long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        // Group indices by their corresponding values in nums
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Calculate distances in linear time per group using prefix sums.
        for (List<Integer> indices : indexMap.values()) {
            int size = indices.size();
            if (size > 1) {
                long totalSum = 0;
                for (int index : indices) {
                    totalSum += index;
                }

                long leftSum = 0;
                for (int i = 0; i < size; i++) {
                    int currentIndex = indices.get(i);
                    long rightSum = totalSum - leftSum - currentIndex;

                    long leftContribution = (long) i * currentIndex - leftSum;
                    long rightContribution = rightSum - (long) (size - i - 1) * currentIndex;

                    arr[currentIndex] = leftContribution + rightContribution;
                    leftSum += currentIndex;
                }
            }
        }

        return arr;
    }
}
