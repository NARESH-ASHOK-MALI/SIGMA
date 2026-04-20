public class detectCapitalUse {
    public static void main(String[] args) {
        detectCapitalUse solution = new detectCapitalUse();
        System.out.println(solution.detectCapitalUse("USA")); // true
        System.out.println(solution.detectCapitalUse("Leetcode")); // true
        System.out.println(solution.detectCapitalUse("Google")); // true
        System.out.println(solution.detectCapitalUse("FlaG")); // false
    }
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upperCount++;
            }
        }

        return upperCount == 0
                || upperCount == word.length()
                || (upperCount == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
