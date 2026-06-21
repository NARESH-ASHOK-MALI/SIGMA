// An array nums of length n is beautiful if:

// nums is a permutation of the integers in the range [1, n].
// For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums[k] == nums[i] + nums[j].
// Given the integer n, return any beautiful array nums of length n. There will be at least one valid answer for the given n.
public class beautifulArray932 {
    public int[] beautifulArray(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }
        return helper(res);
    }
    public int[] helper(int[] arr) {
        if (arr.length <= 2) {
            return arr;
        }
        int[] odd = new int[(arr.length + 1) / 2];
        int[] even = new int[arr.length / 2];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                odd[i / 2] = arr[i];
            } else {
                even[i / 2] = arr[i];
            }
        }
        odd = helper(odd);
        even = helper(even);
        int[] res = new int[arr.length];
        for (int i = 0; i < odd.length; i++) {
            res[i] = odd[i];
        }
        for (int i = 0; i < even.length; i++) {
            res[odd.length + i] = even[i];
        }
        return res;
    }
}
