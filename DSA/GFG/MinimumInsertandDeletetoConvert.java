// Given two arrays a[] and b[] of size n and m respectively, find the minimum number of insertions and deletions on the array a[], required to make both the arrays identical.

// Note: Array b[] is sorted and all its elements are distinct, operations can be performed at any index not necessarily at the end.

// Examples :

// Input: a[] = [1, 2, 5, 3, 1], b[] = [1, 3, 5]
// Output: 4
// Explanation:
// Delete 2 from a: a[] = [1, 5, 3, 1]
// Insert 3 after 1: a[] = [1, 3, 5, 3, 1]
// Delete the last two elements: a[] = [1, 3, 5]
// Total operations = 1 + 1 + 2 = 4.
// Input: a[] = [1, 4], b[] = [1, 4]
// Output : 0
// Explanation: Both the Arrays are already identical.
//  Constraints:
// 1 ≤ n, m ≤ 105
// 1 ≤ a[i], b[i] ≤ 105
import java.util.HashMap;

public class MinimumInsertandDeletetoConvert{
    public static int minInsertDelete(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        // Map each value in b to its index, then find the LIS of the
        // matching indices from a. Because b is sorted and distinct,
        // this equals the LCS length without needing an O(n*m) table.
        HashMap<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < m; i++) {
            positions.put(b[i], i);
        }

        int[] lis = new int[m];
        int lisLength = 0;
        for (int value : a) {
            Integer index = positions.get(value);
            if (index == null) {
                continue;
            }

            int left = 0;
            int right = lisLength;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (lis[mid] < index) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            lis[left] = index;
            if (left == lisLength) {
                lisLength++;
            }
        }

        int lcsLength = lisLength;

        // Minimum insertions and deletions
        int minOperations = (n - lcsLength) + (m - lcsLength);
        return minOperations;
    }
}