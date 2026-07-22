// Given an array arr[], find the minimum number of elements to delete so that the remaining elements form a strictly increasing sequence in the same order.

// Examples:

// Input: arr[] = [5, 6, 1, 7, 4]
// Output: 2
// Explanation: Removing 1 and 4 leaves [5, 6, 7] which is strictly increasing.
// Input: arr[] = [1, 1, 1]
// Output: 2
// Explanation: Removing any 2 elements leaves [1] which is strictly increasing.
// Constraints:
// 1 ≤ n ≤ 105 
// 1 ≤ arr[i] ≤ 105

public class MinimumDeletionstoMakeSorted{
    public int minDeletions(int[] arr) {
        int n = arr.length;
        List<Integer> lis = new ArrayList<>();
        
        for (int num : arr) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos + 1);
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }
        
        return n - lis.size(); // minimum deletions
    }
}