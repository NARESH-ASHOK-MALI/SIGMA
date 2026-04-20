public class maskPersonalInfo {
    public static void main(String[] args) {
        maskPersonalInfo solution = new maskPersonalInfo();
        System.out.println(solution.maskPII("LeetCode@LeetCode.com")); // "l*****e@leetcode.com"
        System.out.println(solution.maskPII("1(234)567-890")); // "***-***-7890"
    }
    public String maskPII(String s) {
        if (s.contains("@")) {
            String[] parts = s.split("@");
            String name = parts[0].toLowerCase();
            String domain = parts[1].toLowerCase();
            return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
        } else {
            String digits = s.replaceAll("\\D", "");
            String local = "***-***-" + digits.substring(digits.length() - 4);
            if (digits.length() > 10) {
                local = "+" + "*".repeat(digits.length() - 10) + "-" + local;
            }
            return local;
        }
    }
