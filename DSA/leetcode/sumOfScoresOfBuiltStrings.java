// You are building a string s of length n one character at a time, prepending each new character to the front of the string. The strings are labeled from 1 to n, where the string with length i is labeled si.

// For example, for s = "abaca", s1 == "a", s2 == "ca", s3 == "aca", etc.
// The score of si is the length of the longest common prefix between si and sn (Note that s == sn).

// Given the final string s, return the sum of the score of every
public class sumOfScoresOfBuiltStrings {
    public long sumScores(String s) {
        int n = s.length();
        int[] z = new int[n];
        z[0] = n;
        long sum = n;
        
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && s.charAt(r - l) == s.charAt(r)) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < n && s.charAt(r - l) == s.charAt(r)) {
                        r++;
                    }
                    z[i] = r - l;
                    r--;
                }
            }
            sum += z[i];
        }
        return sum;
    }
}
