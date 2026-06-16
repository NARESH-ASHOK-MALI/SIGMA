// There is an array that initially contains only a single value, 0.

// Given a list of queries queries[][] of size q, where each query is of one of the following types:

// 0 x: Insert x into the array.
// 1 x: Replace every element a in the array with a ^ x, where ^ denotes the bitwise XOR operator.
// Return the array in sorted order after performing all the queries.
import java.util.ArrayList;
import java.util.Collections;

public class ConstructListusingXORQueries {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(0);

        int xorMask = 0;
        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];

            if (type == 0) {
                values.add(x ^ xorMask);
            } else if (type == 1) {
                xorMask ^= x;
            }
        }

        for (int i = 0; i < values.size(); i++) {
            values.set(i, values.get(i) ^ xorMask);
        }

        Collections.sort(values);
        return values;
    }
}