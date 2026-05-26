// Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.

// If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

// Note that the word should be built from left to right with each additional character being added to the end of a previous word. 
public class LongestWordinDictionary {
    public String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        String longestWord = "";

        for (String word : words) {
            if (isValid(word, wordSet)) {
                if (word.length() > longestWord.length() || 
                    (word.length() == longestWord.length() && word.compareTo(longestWord) < 0)) {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }
    private boolean isValid(String word, Set<String> wordSet) {
        for (int i = 1; i < word.length(); i++) {
            if (!wordSet.contains(word.substring(0, i))) {
                return false;
            }
        }
        return true;
    }
}
