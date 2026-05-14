// You are given two integer arrays a[] and b[]. Return all the starting indexes of all the occurences of b[] as a subarray in a[].
public class searchForSubArray {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        if (b.length == 0 || a.length < b.length) {
            return result;
        }

        int n = a.length;
        int m = b.length;
        int[] lps = computeLPS(b);
        int i = 0, j = 0;

        while (i < n) {
            if (a[i] == b[j]) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - m);
                j = lps[j - 1];
            } else if (i < n && a[i] != b[j]) {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private int[] computeLPS(int[] pattern) {
        int m = pattern.length;
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
