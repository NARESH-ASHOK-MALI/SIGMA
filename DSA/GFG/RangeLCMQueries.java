// Given an array arr[]  and a list of queries queries[][]. Each query can be one of the following two types:

// Update Query: [1, index, value] --> Update the element at position index in the array to the given value.
// Range Query: [2, L, R] --> Compute and return the Least Common Multiple (LCM) of all elements in the subarray from index L to R (inclusive).
// Process all queries sequentially and return a list containing the results of all Type 2 queries.

// Note: All operations follow 0-based indexing.

import java.util.ArrayList;

public class RangeLCMQueries {
    private long[] seg;
    private int n;

    public ArrayList<Long> lcmQueries(int[] arr, int[][] queries) {
        ArrayList<Long> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        n = arr.length;
        seg = new long[4 * n];
        build(1, 0, n - 1, arr);

        for (int[] q : queries) {
            if (q[0] == 1) {
                // Update
                int idx = q[1];
                int val = q[2];
                if (idx >= 0 && idx < n) update(1, 0, n - 1, idx, val);
            } else if (q[0] == 2) {
                int L = q[1];
                int R = q[2];
                if (L < 0) L = 0;
                if (R >= n) R = n - 1;
                if (L <= R) {
                    long res = query(1, 0, n - 1, L, R);
                    result.add(res);
                } else {
                    result.add(1L);
                }
            }
        }
        return result;
    }

    private void build(int node, int l, int r, int[] arr) {
        if (l == r) {
            seg[node] = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(node << 1, l, mid, arr);
        build(node << 1 | 1, mid + 1, r, arr);
        seg[node] = lcm(seg[node << 1], seg[node << 1 | 1]);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            seg[node] = val;
            return;
        }
        int mid = (l + r) >> 1;
        if (idx <= mid) update(node << 1, l, mid, idx, val);
        else update(node << 1 | 1, mid + 1, r, idx, val);
        seg[node] = lcm(seg[node << 1], seg[node << 1 | 1]);
    }

    private long query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) return 1L;
        if (ql <= l && r <= qr) return seg[node];
        int mid = (l + r) >> 1;
        long left = query(node << 1, l, mid, ql, qr);
        long right = query(node << 1 | 1, mid + 1, r, ql, qr);
        return lcm(left, right);
    }

    private long gcd(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0L;
        long g = gcd(a, b);
        return (a / g) * b;
    }
    
}
