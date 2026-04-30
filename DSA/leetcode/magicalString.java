// A magical string s consists of only '1' and '2' and obeys the following rule:

// Concatenating the sequence of lengths of its consecutive groups of identical characters '1' and '2' generates the string s itself.
// The first few elements of s is s = "1221121221221121122……". If we group the consecutive 1's and 2's in s, it will be "1 22 11 2 1 22 1 22 11 2 11 22 ......" and counting the occurrences of 1's or 2's in each group yields the sequence "1 2 2 1 1 2 1 2 2 1 2 2 ......".

// You can see that concatenating the occurrence sequence gives us s itself.

// Given an integer n, return the number of 1's in the first n number in the magical string s.
public class magicalString {
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1; // "122"
        
        StringBuilder s = new StringBuilder("122");
        int count = 1; // Count of '1's in the first 3 characters
        int index = 2; // Start from the third character
        
        while (s.length() < n) {
            char nextChar = s.charAt(s.length() - 1) == '1' ? '2' : '1';
            int repeatCount = s.charAt(index) - '0'; // Get the count from the current index
            for (int i = 0; i < repeatCount && s.length() < n; i++) {
                s.append(nextChar);
                if (nextChar == '1') {
                    count++;
                }
            }
            index++;
        }
        
        return count;
    }
}
