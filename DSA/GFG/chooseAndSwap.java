// Given a string s of lowercase English letters, you can swap all occurrences of any two distinct characters at most once. Return the lexicographically smallest string after this operation.
public class chooseAndSwap{
    public String chooseAndSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] firstIndex = new int[26];

        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (firstIndex[arr[i] - 'a'] == -1) {
                firstIndex[arr[i] - 'a'] = i;
            }
        }

        for (int i = 0; i < n; i++) {
            char currentChar = arr[i];

            for (char c = 'a'; c < currentChar; c++) {
                if (firstIndex[c - 'a'] > i) {
                    // Swap all occurrences of currentChar and c
                    for (int j = 0; j < n; j++) {
                        if (arr[j] == currentChar) {
                            arr[j] = c;
                        } else if (arr[j] == c) {
                            arr[j] = currentChar;
                        }
                    }
                    return new String(arr);
                }
            }
        }
        return s; // Return original string if no swap is made
    }
}