// You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.

// Return the number of special letters in word.
public class countNoOfSpecialCharacterI3120 {
    public int countSpecialCharacters(String word) {
        java.util.Set<Character> lowercaseSet = new java.util.HashSet<>();
        java.util.Set<Character> uppercaseSet = new java.util.HashSet<>();

        // Iterate through the characters in the word and populate the sets
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercaseSet.add(c);
            } else if (Character.isUpperCase(c)) {
                uppercaseSet.add(c);
            }
        }

        // Count the number of special letters
        int specialCount = 0;
        for (char c : lowercaseSet) {
            if (uppercaseSet.contains(Character.toUpperCase(c))) {
                specialCount++;
            }
        }

        return specialCount;
    }
}
