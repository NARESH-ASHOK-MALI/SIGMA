// You are given an integer array nums.

// Return an integer that is the maximum distance between the indices of two (not necessarily different) prime numbers in nums.
class MaxPrimeDiff {
    public int maxPrimeDiff(int[] nums) {
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                if (first == -1) first = i;
                last = i;
            }
        }
        if (first == -1) return -1;
        return last - first;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0) return false;
        int limit = (int) Math.sqrt(num);
        for (int i = 3; i <= limit; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}