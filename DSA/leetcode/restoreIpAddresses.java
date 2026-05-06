// A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
// Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

import java.util.List;

public class restoreIpAddresses {
    public static void main(String[] args) {
        restoreIpAddresses solution = new restoreIpAddresses();
        String s = "25525511135";
        List<String> result = solution.restoreIpAddresses(s);
        System.out.println(result); // Output: ["255.255.11.135","255.255.111.35"]
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;

    }
    private void backtrack(List<String> result, List<String> current, String s, int start) {
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }
        for (int i = start; i < Math.min(start + 3, s.length()); i++) {
            String segment = s.substring(start, i + 1);
            if (isValid(segment)) {
                current.add(segment);
                backtrack(result, current, s, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
    private boolean isValid(String segment) {
        if (segment.length() == 0 || segment.length() > 3) {
            return false;
        }
        if (segment.charAt(0) == '0' && segment.length() > 1) {
            return false;
        }
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }

}
