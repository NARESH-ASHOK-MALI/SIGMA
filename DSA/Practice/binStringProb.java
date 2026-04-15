//Print all binary strings of size N without consecutive ones.

public class binStringProb {
    public static void main(String[] args) {
        int n = 3;
        binString(n, 0, "");
    }

    public static void binString(int n,int lastPlace, String str) {
        if(n==0){
            System.out.println(str);
            return;
        }

        binString(n-1, 0, str+"0");
        if(lastPlace==0){
            binString(n-1, 1, str+"1");
        }
    }
}
