public class reverseInteger07 {
    public static int reverse(int x) {
        int rev=0;
        while(x!=0){
            int pop = x%10;
            x/=10;
            if(rev>Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && pop>7)) return 0;
            if(rev<Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10 && pop<-8)) return 0;
            rev=(rev*10)+pop;
        }
        return rev;
    }
    public static void main(String[] args) {
        int x = -123;//Add test case handling for negative numbers and numbers ending with zero
        int result = reverse(x);
        System.out.println("Reversed integer: " + result);
    }
}
