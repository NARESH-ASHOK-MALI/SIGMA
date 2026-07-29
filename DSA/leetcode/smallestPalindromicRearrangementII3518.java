// You are given a palindromic string s and an integer k.

// Return the k-th lexicographically smallest palindromic permutation of s. If there are fewer than k distinct palindromic permutations, return an empty string.

// Note: Different rearrangements that yield the same palindromic string are considered identical and are counted once.

 

// Example 1:

// Input: s = "abba", k = 2

// Output: "baab"

// Explanation:

// The two distinct palindromic rearrangements of "abba" are "abba" and "baab".
// Lexicographically, "abba" comes before "baab". Since k = 2, the output is "baab".
// Example 2:

// Input: s = "aa", k = 2

// Output: ""

// Explanation:

// There is only one palindromic rearrangement: "aa".
// The output is an empty string since k = 2 exceeds the number of possible rearrangements.
// Example 3:

// Input: s = "bacab", k = 1

// Output: "abcba"

// Explanation:

// The two distinct palindromic rearrangements of "bacab" are "abcba" and "bacab".
// Lexicographically, "abcba" comes before "bacab". Since k = 1, the output is "abcba".
 

// Constraints:

// 1 <= s.length <= 104
// s consists of lowercase English letters.
// s is guaranteed to be palindromic.
// 1 <= k <= 106
public class smallestPalindromicRearrangementII3518{
    private static final long CAP = 1_000_000L;
    public String smallestPallindrome(String s, int k){
        int[] freq = new int[26];

        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        int[] half = new int[26];
        char mid = 0;
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
            if ((freq[i] & 1) == 1)
                mid = (char) ('a' + i);
        }

        if (countWays(half, halfLen) < k)
            return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0)
                    continue;

                half[c]--;

                long ways = countWays(half, halfLen - pos - 1);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder(left);

        if (mid != 0)
            ans.append(mid);

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long countWays(int[] cnt, int total) {
        long res = 1;
        int rem = total;

        for (int x : cnt) {
            if (x == 0)
                continue;

            long choose = combCap(rem, x);

            res *= choose;
            if (res > CAP)
                return CAP + 1;

            rem -= x;
        }

        return res;
    }

    private long combCap(int n, int r) {
        if (r < 0 || r > n)
            return 0;

        r = Math.min(r, n - r);
        long res = 1;

        for (int i = 1; i <= r; i++) {
            long num = n - r + i;
            long den = i;

            long g = gcd(num, den);
            num /= g;
            den /= g;

            g = gcd(res, den);
            res /= g;
            den /= g;

            res *= num;
            res /= den;

            if (res > CAP)
                return CAP + 1;
        }

        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}