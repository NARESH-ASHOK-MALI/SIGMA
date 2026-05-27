// There are n rooms in a straight line in Geekland State University's hostel. You are given a binary string s of length n, where s[i] = '1' means there is a WiFi router in the i-th room, and s[i] = '0' means there is no WiFi in that room.

// Each WiFi router has a range of x, meaning it can cover up to x rooms to its left and x rooms to its right.

// Given x and s, determine whether all rooms are covered by at least one WiFi router. Return true if all rooms are covered; otherwise, return false.
public class wifiRange {
    public boolean wifiRange(int x, String s) {
        int n = s.length();
        // Use a difference array to mark ranges in O(n)
        int[] diff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                int l = Math.max(0, i - x);
                int r = Math.min(n - 1, i + x);
                diff[l] += 1;
                if (r + 1 < diff.length) diff[r + 1] -= 1;
            }
        }

        int cover = 0;
        for (int i = 0; i < n; i++) {
            cover += diff[i];
            if (cover <= 0) return false;
        }
        return true;
    }
}
