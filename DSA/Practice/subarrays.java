import java.util.*;
public class subarrays {
    public static void printSubarrays(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                //print subarray from i to j
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        printSubarrays(arr);
    }
}
