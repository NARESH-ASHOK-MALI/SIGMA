public class palindromeNo9 {
    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if(x<0){
            return false;
        }
        int rev=0;
        int q=x;
        while(x>0){
            rev=(rev*10)+(x%10);
            x/=10;
        }
        if(rev==q){
            return true;
        }
        return false;
    }
}
