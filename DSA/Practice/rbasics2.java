//You are given a number (eg -  2019), convert it into a String of english like
//“two zero one nine”.  Use a recursive function to solve this problem

public class rbasics2 {
    static String [] digits={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void main(String[]args){
        int val=2019;
        printSpell(val);
    }
    public static void printSpell(int val){
        if (val==0){
            return;
        }
        int lastDigit=val%10;
        printSpell(val/10);
        System.out.print(digits[lastDigit]+" ");
    }
}
