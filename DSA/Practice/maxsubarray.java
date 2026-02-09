import java.util.*;
public class maxsubarray {
    public static void maxSubarraySumbruteforce(int arr[]) {
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                currSum=0;
                for(int k=i;k<=j;k++){
                    currSum+=arr[k];
                }
                System.out.println("Subarray sum from index "+i+" to "+j+" is: "+currSum);
                if(maxSum<currSum){
                    maxSum=currSum;
                }
            }
        }
    }


    public static void maxSubarrayPrefixSum(int arr[]) {
        int prefixsum[]=new int[arr.length];
        prefixsum[0]=arr[0];
        for(int i=1;i<prefixsum.length;i++){
            prefixsum[i]=prefixsum[i-1]+arr[i];
        }

        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int currSum=0;
                if(i==0){
                    currSum=prefixsum[j];
                }else{
                    currSum=prefixsum[j]-prefixsum[i-1];
                }
                System.out.println("Subarray sum from index "+i+" to "+j+" is: "+currSum);
                if(maxSum<currSum){
                    maxSum=currSum;
                }
            }
        }
        System.out.println("Maximum Subarray Sum is: "+maxSum);
    }

    public static void maxSubarraySumkadanes(int arr[]) {
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum<0){
                currSum=0;
            }
            maxSum=Math.max(maxSum, currSum);
        }
        System.out.println("Maximum Subarray Sum is: "+maxSum);
    }
    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        maxSubarraySumbruteforce(arr);
    }
}
