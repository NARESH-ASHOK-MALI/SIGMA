// You are given two 0-indexed integer permutations A and B of length n.

// A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

// Return the prefix common array of A and B.

// A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
public class findThePrefixCommonArray2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        boolean[] seenA = new boolean[n + 1];
        boolean[] seenB = new boolean[n + 1];
        
        for (int i = 0; i < n; i++) {
            seenA[A[i]] = true;
            seenB[B[i]] = true;
            C[i] = (i > 0 ? C[i - 1] : 0) + (seenA[A[i]] && seenB[A[i]] ? 1 : 0) + (seenA[B[i]] && seenB[B[i]] && A[i] != B[i] ? 1 : 0);
        }
        
        return C;
    }
}