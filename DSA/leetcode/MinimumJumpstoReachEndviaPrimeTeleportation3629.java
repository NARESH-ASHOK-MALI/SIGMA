// You are given an integer array nums of length n.

// You start at index 0, and your goal is to reach index n - 1.

// From any index i, you may perform one of the following operations:

// Adjacent Step: Jump to index i + 1 or i - 1, if the index is within bounds.
// Prime Teleportation: If nums[i] is a prime number p, you may instantly jump to any index j != i such that nums[j] % p == 0.
// Return the minimum number of jumps required to reach index n - 1.
import java.util.*;

class MinimumJumpstoReachEndviaPrimeTeleportation3629 {
    public int minimumJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        List<Integer>[] valToIndices = new List[maxVal + 1];
        for (int i = 0; i < n; i++) {
            if (valToIndices[nums[i]] == null) {
                valToIndices[nums[i]] = new ArrayList<>();
            }
            valToIndices[nums[i]].add(i);
        }
        
        boolean[] visited = new boolean[n];
        boolean[] usedPrime = new boolean[maxVal + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(0);
        visited[0] = true;
        int jumps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int currentIndex = queue.poll();
                
                if (currentIndex == n - 1) {
                    return jumps;
                }
                
                // Option 1 & 2: Adjacent steps
                if (currentIndex + 1 < n && !visited[currentIndex + 1]) {
                    visited[currentIndex + 1] = true;
                    queue.offer(currentIndex + 1);
                }
                if (currentIndex - 1 >= 0 && !visited[currentIndex - 1]) {
                    visited[currentIndex - 1] = true;
                    queue.offer(currentIndex - 1);
                }
                
                // Option 3: Prime teleportation
                int p = nums[currentIndex];
                if (isPrime(p) && !usedPrime[p]) {
                    usedPrime[p] = true;
                    for (int m = p; m <= maxVal; m += p) {
                        if (valToIndices[m] != null) {
                            for (int nextIndex : valToIndices[m]) {
                                if (!visited[nextIndex]) {
                                    visited[nextIndex] = true;
                                    queue.offer(nextIndex);
                                }
                            }
                        }
                    }
                }
            }
            jumps++;
        }
        
        return -1;
    }
    
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}