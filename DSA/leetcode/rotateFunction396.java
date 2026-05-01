public class rotateFunction396 {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        int sum = 0, f = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            f += i * A[i];
        }
        int max = f;
        for (int i = n - 1; i > 0; i--) {
            f += sum - n * A[i];
            max = Math.max(max, f);
        }
        return max;
    }
}
