// Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].
public class K_thSmallestinLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        long current = 1L;
        long kk = k;
        kk--; // Decrement k to account for the starting point

        while (kk > 0) {
            long count = countPrefix(current, n);
            if (count <= kk) {
                // Move to the next prefix
                current++;
                kk -= count;
            } else {
                // Move down to the next level of the prefix tree
                current *= 10;
                kk--;
            }
        }

        return (int) current;
    }
    private long countPrefix(long prefix, long n) {
        long nextPrefix = prefix + 1;
        long count = 0L;

        while (prefix <= n) {
            count += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }

        return count;
    }
}
