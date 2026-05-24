// Given an array of integers arr and an integer d. In one step you can jump from index i to index:

// i + x where: i + x < arr.length and  0 < x <= d.
// i - x where: i - x >= 0 and  0 < x <= d.
// In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k < max(i, j)).

// You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.

// Notice that you can not jump outside of the array at any time.
import java.util.Arrays;

public class jumpGameV1340 {
    private int[] arr;
    private int n;
    private int d;
    private int[] memo;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.n = arr.length;
        this.d = d;
        this.memo = new int[n];
        Arrays.fill(this.memo, 0);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }

    private int dfs(int i) {
        if (memo[i] != 0) return memo[i];

        int best = 1;

        // jump to the right
        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
            if (arr[j] < arr[i]) {
                best = Math.max(best, 1 + dfs(j));
            } else {
                break;
            }
        }

        // jump to the left
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] < arr[i]) {
                best = Math.max(best, 1 + dfs(j));
            } else {
                break;
            }
        }

        memo[i] = best;
        return best;
    }
}
