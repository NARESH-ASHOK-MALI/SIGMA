import java.util.*;
public class square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        for(int i=1;i<=number;i++){
            for(int j=1;j<=number;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
}