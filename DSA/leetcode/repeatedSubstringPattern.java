public class repeatedSubstringPattern {
    public static void main(String[] args) {
        repeatedSubstringPattern solution = new repeatedSubstringPattern();
        System.out.println(solution.repeatedSubstringPattern("abab")); // true
        System.out.println(solution.repeatedSubstringPattern("aba")); // false
        System.out.println(solution.repeatedSubstringPattern("abcabcabcabc")); // true
    }
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
