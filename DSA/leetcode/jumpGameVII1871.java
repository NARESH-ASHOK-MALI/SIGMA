// You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:

// i + minJump <= j <= min(i + maxJump, s.length - 1), and
// s[j] == '0'.
// Return true if you can reach index s.length - 1 in s, or false otherwise.
public class jumpGameVII1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) != '0') return false;

        boolean[] canReach = new boolean[n];
        canReach[0] = true;

        int window = 0; // number of reachable indices in current [i-maxJump, i-minJump]

        for (int i = 1; i < n; i++) {
            int left = i - maxJump;
            int right = i - minJump;

            if (right >= 0 && canReach[right]) window++;
            if (left - 1 >= 0 && canReach[left - 1]) window--;

            if (window > 0 && s.charAt(i) == '0') {
                canReach[i] = true;
            }
        }

        return canReach[n - 1];
    }
}
