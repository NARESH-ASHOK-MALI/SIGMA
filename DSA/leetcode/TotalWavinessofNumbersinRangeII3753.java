// You are given two integers num1 and num2 representing an inclusive range [num1, num2].

// The waviness of a number is defined as the total count of its peaks and valleys:

// A digit is a peak if it is strictly greater than both of its immediate neighbors.
// A digit is a valley if it is strictly less than both of its immediate neighbors.
// The first and last digits of a number cannot be peaks or valleys.
// Any number with fewer than 3 digits has a waviness of 0.
// Return the total sum of waviness for all numbers in the range [num1, num2].
class TotalWavinessofNumbersinRangeII3753{
    public long totalWaviness(long num1, long num2) {
        if (num2 < num1) return 0;
        return countUpTo(num2) - countUpTo(num1 - 1);
    }

    private int calculateWaviness(int num) {
        String strNum = Integer.toString(num);
        int waviness = 0;
        for (int i = 1; i < strNum.length() - 1; i++) {
            char prev = strNum.charAt(i - 1);
            char curr = strNum.charAt(i);
            char next = strNum.charAt(i + 1);
            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                waviness++;
            }
        }
        return waviness;
    }

    // Digit DP to count total waviness for all numbers in [0, N]
    private int[] digits;
    private java.util.Map<Long, long[]> memo;

    private long countUpTo(long N) {
        if (N < 0) return 0;
        String s = Long.toString(N);
        digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) digits[i] = s.charAt(i) - '0';
        memo = new java.util.HashMap<>();
        long[] res = dfs(0, -1, -1, true, true);
        return res[1]; // sum of waviness
    }

    // returns {ways, totalWaviness}
    private long[] dfs(int pos, int prev, int prev2, boolean tight, boolean leading) {
        if (pos == digits.length) {
            return new long[]{1L, 0L};
        }

        if (!tight) {
            long key = (((long) pos) << 32) | (((long) (prev + 2)) << 16) | (((long) (prev2 + 2)) << 8) | (leading ? 1L : 0L);
            if (memo.containsKey(key)) return memo.get(key);
        }

        int limit = tight ? digits[pos] : 9;
        long totalWays = 0L;
        long totalSum = 0L;

        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && (d == limit);
            boolean nextLeading = leading && (d == 0);

            int newPrev2 = prev;
            int newPrev = nextLeading ? -1 : d;

            int added = 0;
            if (prev != -1 && prev2 != -1) {
                if ((prev > prev2 && prev > d) || (prev < prev2 && prev < d)) added = 1;
            }

            long[] sub = dfs(pos + 1, newPrev, newPrev2, nextTight, nextLeading);
            long waysSub = sub[0];
            long sumSub = sub[1];

            totalWays += waysSub;
            totalSum += sumSub + waysSub * added;
        }

        long[] out = new long[]{totalWays, totalSum};
        if (!tight) {
            long key = (((long) pos) << 32) | (((long) (prev + 2)) << 16) | (((long) (prev2 + 2)) << 8) | (leading ? 1L : 0L);
            memo.put(key, out);
        }
        return out;
    }
}