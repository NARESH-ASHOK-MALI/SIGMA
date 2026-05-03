public class rotateString796 {
    public static void main(String[] args) {
        rotateString796 solution = new rotateString796();
        System.out.println(solution.rotateString("abcde", "cdeab")); // true
        System.out.println(solution.rotateString("abcde", "abced")); // false
    }
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String combined = s + s;
        return combined.contains(goal);
    }
}
