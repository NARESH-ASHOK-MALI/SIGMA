public class shortestPalindrome {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String l = s + "#" + rev;
        int[] p = new int[l.length()];
        for (int i = 1; i < l.length(); i++) {
            int j = p[i - 1];
            while (j > 0 && l.charAt(i) != l.charAt(j)) {
                j = p[j - 1];
            }
            if (l.charAt(i) == l.charAt(j)) {
                j++;
            }
            p[i] = j;
        }
        return rev.substring(0, rev.length() - p[p.length - 1]) + s;
    }
}
