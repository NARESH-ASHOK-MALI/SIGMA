// An array is monotonic if it is either monotone increasing or monotone decreasing.

// An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

// Given an integer array nums, return true if the given array is monotonic, or false otherwise.
class monotinicArray896 {
    public boolean isMonotonic(int[] nums) {
        boolean inc=true;
        boolean dec=true;
        for (int i = 1 ; i < nums.length ; i++ ){
            if(nums[i-1]>nums[i]){
                inc=false;
            }else if(nums[i-1]<nums[i]){
                dec=false;
            }
        }
        
        return inc||dec;
    }
}