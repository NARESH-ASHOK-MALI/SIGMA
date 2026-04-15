//Write a program to find Length of a String using Recursion
public class rbasics3 {
    public static void main(String[] args) {
        String str="hello i am Lara";
        System.out.println(length(str));
    }
    public static int length(String Str){
        if(Str.length()==0){
            return 0;
        }
        return length(Str.substring(1)) +1;
    }
}
