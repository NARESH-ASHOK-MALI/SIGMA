import java.util.*;
public class dec2bin {
    public static int convertDecimalToBinary(int n) {
        int pow=0;
        int binNum=0;
        while(n>0){
            int rem=n%2;
            binNum+=(rem*(int)Math.pow(10,pow));
            pow++;
            n/=2;
        }
        return binNum;
    }
    public static void main(String[] args) {
        System.out.println(convertDecimalToBinary(80));
    }
}
