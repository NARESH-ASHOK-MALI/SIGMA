// Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: 6
// Example 2:

// Input: nums = [1,2,3,4]
// Output: 24
// Example 3:

// Input: nums = [-1,-2,-3]
// Output: -6
 

// Constraints:

// 3 <= nums.length <= 104
// -1000 <= nums[i] <= 1000
public class MaximumProductOfThreeNumbers628 {
    public int maximumProduct(int[] nums) {
        int m1=Integer.MIN_VALUE;
        int m2=Integer.MIN_VALUE;
        int m3=Integer.MIN_VALUE;
        int s1=Integer.MAX_VALUE;
        int s2=Integer.MAX_VALUE;
        for(int num:nums){
            if(num>m1){
                m3=m2;
                m2=m1;
                m1=num;
            }else if(num>m2){
                m3=m2;
                m2=num;
            }else if(num>m3) m3=num;

            if(num<s1){
                s2=s1;
                s1=num;
            }else if(num<s2){
                s2=num;
            }
        }
        return Math.max((m1*m2*m3),(m1*s1*s2));
    }
}