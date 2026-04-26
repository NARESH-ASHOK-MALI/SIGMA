public class minWindow76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] charCount = new int[128];
        for (char c : t.toCharArray()) {
            charCount[c]++;
        }

        int left = 0, right = 0, count = t.length(), minLen = Integer.MAX_VALUE, start = 0;
        while (right < s.length()) {
            if (charCount[s.charAt(right)] > 0) {
                count--;
            }
            charCount[s.charAt(right)]--;
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                charCount[s.charAt(left)]++;
                if (charCount[s.charAt(left)] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
