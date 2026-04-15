//We aregivenastring S, weneedto find the count of all contiguous substrings
//starting and ending with the same character.
public class rbasics4 {
    public static void main(String args[]){
        String S="abcab";
        int n=S.length();
        System.out.println(count(S,0,n-1,n));
    }
    public static int count(String S,int i ,int j,int n){
        if(n==1){
            return 1;
        }
        if(n<=1){
            return 0;
        }
        int res=count(S, i+1, j, n-1)+count(S, i, j-1, n-1)-count(S, i+1, j-1, n-2);
        if(S.charAt(i)==S.charAt(j)){
            res++;
        }
        return res;
    } 
}
