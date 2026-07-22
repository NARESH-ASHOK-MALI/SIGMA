// Given an array arr[] and a list of queries. For each query [l, r], find whether the subarray arr[l...r] is a mountain array. A subarray is called a mountain array if there exists an index k (l ≤ k ≤ r) such that: arr[l] ≤ arr[l + 1] ≤ ... ≤ arr[k] ≥ arr[k + 1] ≥ ... ≥ arr[r].

// Elements of a Mountain subarray are first non-decreasing and then non-increasing.
// A subarray that is entirely non-decreasing or entirely non-increasing is also considered a mountain.
// Examples:

// Input: arr[] = [2, 3, 2, 4, 4, 6, 3, 2], queries[][] = [[0, 2], [1, 3]]
// Output: [true, false]
// Explanation: For query [0, 2], the subarray is [2, 3, 2]. The elements first increase and then decrease, so it forms a mountain.
// For query [1, 3], the subarray is [3, 2, 4]. The elements decrease and then increase, so it does not form a mountain.
// Input: arr[] = [2, 2, 2, 2], queries[][] = [[0, 2], [1, 3]]
// Output: [true, true]
// Explanation: All subarrays of the given array are mountain.
// Constraints:
// 1 <= arr.size(), queries.size() <= 105
// 1 <= arr[i] <= 106
// 0 <= l <= r < arr.size()

import java.util.ArrayList;

public class MountainArrayQueries {
    public static ArrayList<Boolean> checkMountainArray(int[] arr, int[][] queries) {
        int[] badPrefix = buildBadPrefix(arr);
        ArrayList<Boolean> results = new ArrayList<>();
        
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            results.add(isMountain(badPrefix, l, r));
        }
        
        return results;
    }
    
    private static int[] buildBadPrefix(int[] arr) {
        int n = arr.length;
        int[] badPrefix = new int[n];

        for (int i = 1; i < n; i++) {
            int bad = 0;
            if (i < n - 1 && arr[i - 1] > arr[i] && arr[i] <= arr[i + 1]) {
                bad = 1;
            }
            badPrefix[i] = badPrefix[i - 1] + bad;
        }

        return badPrefix;
    }

    private static boolean isMountain(int[] badPrefix, int l, int r) {
        if (l == r) {
            return true;
        }
        return badPrefix[r - 1] == badPrefix[l];
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 2, 4, 4, 6, 3, 2};
        int[][] queries1 = {{0, 2}, {1, 3}};
        ArrayList<Boolean> result1 = checkMountainArray(arr1, queries1);
        System.out.println(result1); // Output: [true, false]

        int[] arr2 = {2, 2, 2, 2};
        int[][] queries2 = {{0, 2}, {1, 3}};
        ArrayList<Boolean> result2 = checkMountainArray(arr2, queries2);
        System.out.println(result2); // Output: [true, true]
    }
}