public class licenseKeyFormatting {
    public static void main(String[] args) {
        licenseKeyFormatting solution = new licenseKeyFormatting();
        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-w", 4)); // "5F3Z-2E9W"
        System.out.println(solution.licenseKeyFormatting("2-5g-3-J", 2)); // "2-5G-3J"
    }
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                if (count == k) {
                    sb.append('-');
                    count = 0;
                }
                sb.append(Character.toUpperCase(c));
                count++;
            }
        }

        return sb.reverse().toString();
    }
}
