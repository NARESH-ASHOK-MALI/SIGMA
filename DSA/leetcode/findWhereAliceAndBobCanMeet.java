import java.util.*;

// You are given a 0-indexed array heights of positive integers, where heights[i] represents the height of the ith building.

// If a person is in building i, they can move to any other building j if and only if i < j and heights[i] < heights[j].

// You are also given another array queries where queries[i] = [ai, bi]. On the ith query, Alice is in building ai while Bob is in building bi.

// Return an array ans where ans[i] is the index of the leftmost building where Alice and Bob can meet on the ith query. If Alice and Bob cannot move to a common building on query i, set ans[i] to -1.

 
public class findWhereAliceAndBobCanMeet {
    private static class Query {
        int activateAt;
        int threshold;
        int index;

        Query(int activateAt, int threshold, int index) {
            this.activateAt = activateAt;
            this.threshold = threshold;
            this.index = index;
        }
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        List<Query> pending = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            if (a == b || heights[a] < heights[b]) {
                ans[i] = b;
            } else {
                pending.add(new Query(b + 1, heights[a], i));
            }
        }

        pending.sort(Comparator.comparingInt(query -> query.activateAt));
        PriorityQueue<Query> active = new PriorityQueue<>(Comparator.comparingInt(query -> query.threshold));
        int pointer = 0;

        for (int i = 0; i < n; i++) {
            while (pointer < pending.size() && pending.get(pointer).activateAt <= i) {
                active.offer(pending.get(pointer++));
            }

            while (!active.isEmpty() && active.peek().threshold < heights[i]) {
                ans[active.poll().index] = i;
            }
        }

        return ans;
    }
}
