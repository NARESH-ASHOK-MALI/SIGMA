// You are given an integer side, representing the edge length of a square with corners at (0, 0), (0, side), (side, 0), and (side, side) on a Cartesian plane.

// You are also given a positive integer k and a 2D integer array points, where points[i] = [xi, yi] represents the coordinate of a point lying on the boundary of the square.

// You need to select k elements among points such that the minimum Manhattan distance between any two points is maximized.

// Return the maximum possible minimum Manhattan distance between the selected k points.

// The Manhattan Distance between any two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.
import java.util.Arrays;
class maxDistance3464 {

    public int maxDistance(int side, int[][] points, int k) {
        long[] perimeter = new long[points.length];
        for (int i = 0; i < points.length; i++) {
            perimeter[i] = toPerimeterIndex(side, points[i]);
        }
        Arrays.sort(perimeter);

        long left = 0;
        long right = 2L * side;
        long result = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canSelect(perimeter, side, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) result;
    }

    private boolean canSelect(long[] perimeter, int side, int k, long distance) {
        int n = perimeter.length;
        long circle = 4L * side;
        long[] points = new long[n * 2];
        for (int i = 0; i < n; i++) {
            points[i] = perimeter[i];
            points[i + n] = perimeter[i] + circle;
        }

        int log = 1;
        while ((1L << log) <= k) {
            log++;
        }

        int[] next = new int[n * 2];
        int j = 0;
        for (int i = 0; i < n * 2; i++) {
            if (j < i + 1) {
                j = i + 1;
            }
            while (j < n * 2 && points[j] < points[i] + distance) {
                j++;
            }
            next[i] = j;
        }

        int[][] jump = new int[log][n * 2 + 1];
        for (int i = 0; i < n * 2; i++) {
            jump[0][i] = next[i];
        }
        jump[0][n * 2] = n * 2;

        for (int p = 1; p < log; p++) {
            for (int i = 0; i <= n * 2; i++) {
                int mid = jump[p - 1][i];
                jump[p][i] = mid >= n * 2 ? n * 2 : jump[p - 1][mid];
            }
        }

        long maxSpan = circle - distance;
        for (int start = 0; start < n; start++) {
            int idx = start;
            int steps = k - 1;
            for (int bit = 0; bit < log; bit++) {
                if (((steps >> bit) & 1) == 1) {
                    idx = jump[bit][idx];
                    if (idx >= start + n) {
                        break;
                    }
                }
            }
            if (idx < start + n && points[idx] - points[start] <= maxSpan) {
                return true;
            }
        }
        return false;
    }

    private long toPerimeterIndex(int side, int[] point) {
        int x = point[0];
        int y = point[1];
        if (x == 0) {
            return y;
        }
        if (y == side) {
            return (long) side + x;
        }
        if (x == side) {
            return (long) 3 * side - y;
        }
        return (long) 4 * side - x;
    }
}