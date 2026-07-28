// You are given a palindromic string s.

// Return the lexicographically smallest palindromic permutation of s.

 

// Example 1:

// Input: s = "z"

// Output: "z"

// Explanation:

// A string of only one character is already the lexicographically smallest palindrome.

// Example 2:

// Input: s = "babab"

// Output: "abbba"

// Explanation:

// Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.

// Example 3:

// Input: s = "daccad"

// Output: "acddca"

// Explanation:

// Rearranging "daccad" → "acddca" gives the smallest lexicographic palindrome.

 

// Constraints:

// 1 <= s.length <= 105
// s consists of lowercase English letters.
// s is guaranteed to be palindromic.
class SmallestPalindromicRearrangementI3517 {
    public String smallestPalindrome(String s) {
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder left=new StringBuilder();
        char middle=0;
        for(int i = 0; i<26;i++){
            if(freq[i]%2==1&&middle==0){
                middle=(char)(i+'a');
            }
            for(int j = 0 ; j < freq[i]/2;j++){
                left.append((char)(i+'a'));
            }
        }
        StringBuilder res=new StringBuilder();
        res.append(left);
        if(middle!=0) res.append(middle);
        res.append(left.reverse());
        return res.toString();
    }
}