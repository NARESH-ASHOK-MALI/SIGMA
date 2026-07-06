// Given two sorted arrays of distinct integers in increasing order a[] and b[], which may have some common elements, find the maximum sum of a path from the beginning of any array to the end of any array. You may switch from one array to the other only at common elements.

// Note:  When switching, count the common element only once.

// Examples : 

// Input: a[] = [2, 3, 7, 10, 12], b[] = [1, 5, 7, 8]
// Output: 35
// Explanation: The path will be (1 + 5 + 7 + 10 + 12) = 35, where 1 and 5 come from arr2 and then 7 is common so we switch to arr1 and add 10 and 12.
// Input: a[] = [1, 2, 3], b[] = [3, 4, 5]
// Output: 15
// Explanation: The path will be (1 + 2 + 3 + 4 + 5) = 15.
// Constraints:
// 1 ≤ a.size(), b.size() ≤ 104
// 1 ≤ a[i], b[i] ≤ 105
public class MaxSumPathinTwoArrays{
    public static int maxSumPath(int[] a, int[] b) {
        int i = 0, j = 0;
        int sumA = 0, sumB = 0, result = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                sumA += a[i++];
            } else if (a[i] > b[j]) {
                sumB += b[j++];
            } else {
                result += Math.max(sumA, sumB) + a[i];
                sumA = 0;
                sumB = 0;
                i++;
                j++;
            }
        }

        while (i < a.length) {
            sumA += a[i++];
        }

        while (j < b.length) {
            sumB += b[j++];
        }

        result += Math.max(sumA, sumB);
        return result;
    }
}