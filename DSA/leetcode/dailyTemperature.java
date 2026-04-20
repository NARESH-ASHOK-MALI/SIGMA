public class dailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(temperatures);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for(int i = 0; i < n; i++){
            while(top >= 0 && temperatures[i] > temperatures[stack[top]]){
                int prevIndex = stack[top--];
                ans[prevIndex] = i - prevIndex;
            }
            stack[++top] = i;
        }
        return ans;
    }
}
