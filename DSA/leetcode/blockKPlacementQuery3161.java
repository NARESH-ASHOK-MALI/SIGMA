// There exists an infinite number line, with its origin at 0 and extending towards the positive x-axis.

// You are given a 2D array queries, which contains two types of queries:

// For a query of type 1, queries[i] = [1, x]. Build an obstacle at distance x from the origin. It is guaranteed that there is no obstacle at distance x when the query is asked.
// For a query of type 2, queries[i] = [2, x, sz]. Check if it is possible to place a block of size sz anywhere in the range [0, x] on the line, such that the block entirely lies in the range [0, x]. A block cannot be placed if it intersects with any obstacle, but it may touch it. Note that you do not actually place the block. Queries are separate.
// Return a boolean array results, where results[i] is true if you can place the block specified in the ith query of type 2, and false otherwise.
import java.util.*;

public class blockKPlacementQuery3161 {

    // Segment tree for range maximum query (point update)
    static class SegTree {
        int n;
        int[] st;
        SegTree(int n) {
            this.n = n;
            st = new int[4 * n + 5];
        }
        void update(int p, int val) {
            update(1, 1, n, p, val);
        }
        void update(int node, int l, int r, int p, int val) {
            if (l == r) {
                st[node] = val;
                return;
            }
            int mid = (l + r) >>> 1;
            if (p <= mid) update(node << 1, l, mid, p, val);
            else update(node << 1 | 1, mid + 1, r, p, val);
            st[node] = Math.max(st[node << 1], st[node << 1 | 1]);
        }
        int queryMax(int L, int R) {
            if (L > R) return 0;
            return queryMax(1, 1, n, L, R);
        }
        int queryMax(int node, int l, int r, int L, int R) {
            if (L <= l && r <= R) return st[node];
            int mid = (l + r) >>> 1;
            int res = 0;
            if (L <= mid) res = Math.max(res, queryMax(node << 1, l, mid, L, R));
            if (R > mid) res = Math.max(res, queryMax(node << 1 | 1, mid + 1, r, L, R));
            return res;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        // collect all obstacle positions from type-1 queries for coordinate compression
        TreeSet<Integer> posSet = new TreeSet<>();
        for (int[] q : queries) if (q[0] == 1) posSet.add(q[1]);

        List<Integer> posList = new ArrayList<>(posSet);
        int m = posList.size();

        // map position -> index (1-based)
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < m; i++) idx.put(posList.get(i), i + 1);

        SegTree seg = m > 0 ? new SegTree(m) : null;
        TreeSet<Integer> obstacles = new TreeSet<>();
        List<Boolean> results = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                int p = q[1];
                // insert obstacle p
                Integer leftOb = obstacles.lower(p);
                Integer rightOb = obstacles.higher(p);
                int left = (leftOb == null ? 0 : leftOb);

                // update gap for right obstacle
                if (rightOb != null && m > 0) {
                    seg.update(idx.get(rightOb), rightOb - p);
                }
                // add gap for p: (p - left)
                if (m > 0) seg.update(idx.get(p), p - left);

                obstacles.add(p);

            } else {
                int x = q[1], sz = q[2];
                if (sz > x) {
                    results.add(false);
                    continue;
                }

                Integer leftOb = obstacles.floor(x);
                if (leftOb != null && x - leftOb >= sz) {
                    results.add(true);
                    continue;
                }

                // If there are no inserted obstacles at all, or the smallest inserted
                // obstacle is beyond x, the interval [0,x] is completely free.
                if (obstacles.isEmpty() || obstacles.first() > x) {
                    results.add(sz <= x);
                    continue;
                }

                if (m == 0) {
                    // no obstacle positions ever declared for compression
                    results.add(sz <= x);
                    continue;
                }

                // find index of largest position <= x
                int lo = 0, hi = m - 1, posIdx = -1;
                while (lo <= hi) {
                    int mid = (lo + hi) >>> 1;
                    if (posList.get(mid) <= x) {
                        posIdx = mid;
                        lo = mid + 1;
                    } else hi = mid - 1;
                }

                if (posIdx == -1) {
                    // all obstacles are beyond x → free interval [0,x]
                    results.add(sz <= x);
                    continue;
                }

                int best = seg.queryMax(1, posIdx + 1);
                results.add(best >= sz);
            }
        }
        return results;
    }

    // Example usage
    public static void main(String[] args) {
        blockKPlacementQuery3161 solver = new blockKPlacementQuery3161();
        int[][] queries = {
            {1, 5},
            {2, 7, 3},
            {1, 10},
            {2, 12, 6},
            {2, 4, 4}
        };
        System.out.println(solver.getResults(queries));
        // Expected: [true, true, false]
    }
}
