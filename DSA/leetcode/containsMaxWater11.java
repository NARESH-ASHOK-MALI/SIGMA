// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

 
public class containsMaxWater11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int ans = maxArea(height);
        System.out.println(ans);
    }
    public static int maxArea(int[] height) {
        int n = height.length;
        int lp = 0;              // left pointer
        int rp = n - 1;          // right pointer
        int maxArea = 0;

        // Use two-pointer technique
        while (lp < rp) {
            int minHeight = Math.min(height[lp], height[rp]);
            int width = rp - lp;
            int area = minHeight * width;
            maxArea = Math.max(maxArea, area);

            // Move the pointer at the smaller height inward
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxArea;
    }
}