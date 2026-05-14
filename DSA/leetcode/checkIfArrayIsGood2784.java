// You are given an integer array nums. We consider an array good if it is a permutation of an array base[n].

// base[n] = [1, 2, ..., n - 1, n, n] (in other words, it is an array of length n + 1 which contains 1 to n - 1 exactly once, plus two occurrences of n). For example, base[1] = [1, 1] and base[3] = [1, 2, 3, 3].

// Return true if the given array is good, otherwise return false.

// Note: A permutation of integers represents an arrangement of these numbers.
public class checkIfArrayIsGood2784 {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int[] count = new int[n + 1];
        for (int num : nums) {
            if (num < 1 || num > n) {
                return false;
            }
            count[num]++;
        }
        for (int i = 1; i < n; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        return count[n] == 2;
    }


}
