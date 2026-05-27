// You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word, and every lowercase occurrence of c appears before the first uppercase occurrence of c.

// Return the number of special letters in word.
public class CountNoOFSpecialCharactersII3121 {
    public int countSpecialCharacters(String word) {
        int count = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            char upperC = Character.toUpperCase(c);
            int firstUpper = word.indexOf(upperC);
            int lastLower = word.lastIndexOf(c);
            if (firstUpper != -1 && lastLower != -1 && lastLower < firstUpper) {
                count++;
            }
        }
        return count;
    }
}
