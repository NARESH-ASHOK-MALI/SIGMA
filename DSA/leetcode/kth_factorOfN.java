// You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.

// Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.
class kth_factorOfN {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        
        if (k > factors.size()) {
            return -1;
        }
        
        return factors.get(k - 1);
    }
}