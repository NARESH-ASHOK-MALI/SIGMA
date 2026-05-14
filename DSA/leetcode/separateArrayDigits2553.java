// Given an array of positive integers nums, return an array answer that consists of the digits of each integer in nums after separating them in the same order they appear in nums.

// To separate the digits of an integer is to get all the digits it has in the same order.

// For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].
public class separateArrayDigits2553 {
    public static void main(String [] args){
        int[] nums = {13,25,83,77};
        System.out.println(separateDigits(nums));
    }
    public static int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        int[] result = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            result[i] = sb.charAt(i) - '0'; // Convert char to int
        }
        return result;
    }
}
