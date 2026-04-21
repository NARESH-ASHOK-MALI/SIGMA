//https://leetcode.com/problems/repeated-string-match?envType=problem-list-v2&envId=dsa-sequence-valley-string-matching

public class repeatedStringMatch {
    public static void main(String[] args) {
        repeatedStringMatch solution = new repeatedStringMatch();
        System.out.println(solution.repeatedStringMatch("abcd", "cdabcdab")); // 3
        System.out.println(solution.repeatedStringMatch("a", "aa")); // 2
        System.out.println(solution.repeatedStringMatch("abc", "wxyz")); // -1
    }
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if (sb.toString().contains(b)) {
            return count;
        }
        sb.append(a);
        count++;
        if (sb.toString().contains(b)) {
            return count;
        }
        return -1;
    }
}
