// Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.

// Notice that you can not jump outside of the array at any time.
public class jumpGameIII1306 {
    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0 || start < 0 || start >= arr.length) {
            return false;
        }

        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }
    private boolean dfs(int[] arr, int index, boolean[] visited) {
        if (arr[index] == 0) {
            return true;
        }
        if (visited[index]) {
            return false;
        }

        visited[index] = true;

        int forwardIndex = index + arr[index];
        int backwardIndex = index - arr[index];

        return (forwardIndex < arr.length && dfs(arr, forwardIndex, visited)) ||
               (backwardIndex >= 0 && dfs(arr, backwardIndex, visited));
    }
}
