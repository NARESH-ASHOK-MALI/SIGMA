public class rotatedDigits788 {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }
    public boolean isGood(int num) {
        boolean valid = false;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                valid = true;
            }
            num /= 10;
        }
        return valid;
    }
}
