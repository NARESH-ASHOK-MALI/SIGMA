// Given a binary string s consists only of 0s and 1s. Calculate the number of substrings that have more 1s than 0s.

// Examples:

// Input: s = "011"
// Output: 4
// Explanation: There are 4 substring which has more 1s than 0s. i.e "011","1","11" and "1"
// Input: s = "0000"
// Output: 0
// Explanation: There is no substring with more 1s than 0s
// Constraints:
// 1 < |s| <  6 * 104
import java.util.*;

public class Substringswithmore1sthan0s{
    // Compatibility method (keeps original signature).
    public int countSubstring(String s) {
        long ans = countSubstringsFast(s);
        return (int) ans;
    }

    // Fast O(n log n) solution using prefix sums + Fenwick (BIT).
    public long countSubstringsFast(String s) {
        int n = s.length();

        long[] pref = new long[n + 1];
        pref[0] = 0;
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + (s.charAt(i - 1) == '1' ? 1 : -1);
        }

        // Coordinate compression
        long[] vals = pref.clone();
        Arrays.sort(vals);
        Map<Long, Integer> idxMap = new HashMap<>();
        int idx = 1;
        for (long v : vals) {
            if (!idxMap.containsKey(v)) {
                idxMap.put(v, idx++);
            }
        }

        int m = idx; // size of BIT (1-based up to idx-1)
        int[] bit = new int[m + 1];

        long ans = 0;
        for (int i = 0; i <= n; i++) {
            int id = idxMap.get(pref[i]);
            ans += sum(bit, id - 1); // number of previous prefixes with value < current
            add(bit, id, 1);
        }

        return ans;
    }

    private void add(int[] bit, int i, int delta) {
        while (i < bit.length) {
            bit[i] += delta;
            i += i & -i;
        }
    }

    private int sum(int[] bit, int i) {
        int s = 0;
        while (i > 0) {
            s += bit[i];
            i -= i & -i;
        }
        return s;
    }
}