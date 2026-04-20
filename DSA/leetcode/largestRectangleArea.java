public class largestRectangleArea {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int ans = largestRectangleArea(heights);
        System.out.println(ans);
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] stack = new int[n];
        int top = -1;

        for(int i = 0; i < n; i++){
            while(top >= 0 && heights[i] < heights[stack[top]]){
                int height = heights[stack[top--]];
                int width = top == -1 ? i : i - stack[top] - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack[++top] = i;
        }

        while(top >= 0){
            int height = heights[stack[top--]];
            int width = top == -1 ? n : n - stack[top] - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
