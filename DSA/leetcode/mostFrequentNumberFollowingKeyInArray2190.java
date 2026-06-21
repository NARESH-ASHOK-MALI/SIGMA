// You are given a 0-indexed integer array nums. You are also given an integer key, which is present in nums.

// For every unique integer target in nums, count the number of times target immediately follows an occurrence of key in nums. In other words, count the number of indices i such that:

// 0 <= i <= nums.length - 2,
// nums[i] == key and,
// nums[i + 1] == target.
// Return the target with the maximum count. The test cases will be generated such that the target with maximum count is unique.
public class mostFrequentNumberFollowingKeyInArray2190{
    public int mostFrequent(int[] nums, int key) {
        int res[]=new int[1000];
        for(int i = 0 ; i < nums.length-1 ; i++ ) {
            if ( nums[i]==key){
                res[nums[i+1]-1]++;
            }
        }
        int max= Integer.MIN_VALUE;
        int ans=0;
        for (int i = 0 ; i < 1000 ; i++ ){
            if(res[i]>max){
                max=res[i];
                ans=i+1;
            }
        }
        return ans;
    }
}