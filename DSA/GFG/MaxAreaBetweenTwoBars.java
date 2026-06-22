// Given an integer array height[], where height[i] represents the height of the ith bar arranged in a row, find the maximum rectangular area that can be formed by selecting any two bars. The area is calculated based on the original positions of the selected bars.

import java.util.Arrays;
import java.util.List;

public class MaxAreaBetweenTwoBars {
    public static int maxArea(List<Integer> height) {
        int maxArea = 0;
        int left = 0;
        int right = height.size() - 1;

        while (left < right) {
            // Calculate the area formed by the current pair of bars
            int currentArea = Math.min(height.get(left), height.get(right)) * (right - left - 1);
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer that points to the shorter bar
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        List<Integer> height = Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7);
        System.out.println("Maximum area: " + maxArea(height)); // Output: Maximum area: 49
    }
}