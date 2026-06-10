import java.util.*;

// Fast solution: build sparse tables for range max and min (O(n log n) preprocess, O(1) queries),
// then treat for each left index `l` the sequence of values for r in [l..n-1] which is non-decreasing with r.
// Push the largest r (n-1) for every l into a max-heap; pop k times, and when popping (l,r) push (l,r-1).
// Each popped value is the next largest unused subarray value. Time: O((n + k) log n) after preprocessing.
public class maximumTotalSubArrayValueII3691 {
    static class Entry {
        long val;
        int l, r;
        Entry(long val, int l, int r) { this.val = val; this.l = l; this.r = r; }
    }

    public long maxTotalValue(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return 0L;
        int n = nums.length;

        long totalSub = (long)n * (n + 1) / 2;
        if (k > totalSub) k = (int)totalSub;

        int LOG = 32 - Integer.numberOfLeadingZeros(n);
        int[][] stMax = new int[LOG][n];
        int[][] stMin = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }
        for (int j = 1; j < LOG; j++) {
            int len = 1 << (j - 1);
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[j][i] = Math.max(stMax[j - 1][i], stMax[j - 1][i + len]);
                stMin[j][i] = Math.min(stMin[j - 1][i], stMin[j - 1][i + len]);
            }
        }

        // helper for range queries
        class Querier {
            int queryMax(int l, int r) {
                int len = r - l + 1;
                int j = 31 - Integer.numberOfLeadingZeros(len);
                int pw = 1 << j;
                return Math.max(stMax[j][l], stMax[j][r - pw + 1]);
            }
            int queryMin(int l, int r) {
                int len = r - l + 1;
                int j = 31 - Integer.numberOfLeadingZeros(len);
                int pw = 1 << j;
                return Math.min(stMin[j][l], stMin[j][r - pw + 1]);
            }
            long rangeVal(int l, int r) {
                return (long)queryMax(l, r) - (long)queryMin(l, r);
            }
        }

        Querier q = new Querier();

        PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));
        for (int l = 0; l < n; l++) {
            long v = q.rangeVal(l, n - 1);
            pq.offer(new Entry(v, l, n - 1));
        }

        long ans = 0L;
        for (int t = 0; t < k && !pq.isEmpty(); t++) {
            Entry e = pq.poll();
            ans += e.val;
            if (e.r - 1 >= e.l) {
                long nv = q.rangeVal(e.l, e.r - 1);
                pq.offer(new Entry(nv, e.l, e.r - 1));
            }
        }

        return ans;
    }
}