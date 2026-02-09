
import java.util.*;
public class primeornot {
    public static  void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a no.");
        int n=sc.nextInt();
        boolean prime=true;
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0){
                prime=false;
            }else{
                continue;
            }
        }
        if (prime==true) {
            System.out.println("Number entered was Prime ");
        }else{
            System.out.println("It is not prime");
        }
    } 
}
