// Given an array arr[] consisting of n strings. Determine whether there exists a pair of indices (i, j) such that i ≠ j and the concatenation arr[i] + arr[j] forms a palindrome.

// Return true if such a pair exists; otherwise, return false.

// Note: A string is considered a palindrome if it reads the same forward and backward.
import java.util.HashMap;
import java.util.Map;

public class PalindromePair {
    public static void main(String [] args){
        String[] arr = {"abc", "def", "cba"};
        System.out.println(palindromePair(arr));
    }
    
    public static boolean palindromePair(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        
        // Store all strings and their indices
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        
        // Check each string
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            String reversed = new StringBuilder(str).reverse().toString();
            
            // Check if reverse exists at different index
            if (map.containsKey(reversed) && map.get(reversed) != i) {
                return true;
            }
            
            // Check all split points for palindrome pairs
            for (int j = 0; j < str.length(); j++) {
                String left = str.substring(0, j);
                String right = str.substring(j);
                
                // If left is palindrome, check if reverse of right exists
                if (isPalindrome(left)) {
                    String rightReversed = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(rightReversed) && map.get(rightReversed) != i) {
                        return true;
                    }
                }
                
                // If right is palindrome, check if reverse of left exists
                if (isPalindrome(right)) {
                    String leftReversed = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(leftReversed) && map.get(leftReversed) != i) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
