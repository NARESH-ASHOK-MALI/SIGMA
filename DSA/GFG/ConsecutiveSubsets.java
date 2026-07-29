// Given an array arr[] of distinct positive numbers. Split the array into the minimum number of subsets such that each subset contains consecutive numbers.

// Examples:

// Input: arr[] = [100, 56, 5, 6, 102, 58, 101, 57, 7, 103, 59]
// Output: 3
// Explanation: [5, 6, 7], [56, 57, 58, 59], [100, 101, 102, 103] are 3 subsequences in which numbers are consecutive.
// Input: arr[] = [10, 100, 105]
// Output: 3
// Explanation: [10], [100] and [105] are 3 subset in which numbers are consecutive.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 0 ≤ arr[i] ≤ 109
public class ConsecutiveSubsets {
    public static int SplitArrayintoMinimumConsecutiveSubsets(int[] arr) {
        // Sort the array to group consecutive numbers together
        Arrays.sort(arr);
        
        int count = 0;
        int i = 0;
        int n = arr.length;

        while (i < n) {
            count++; // Start a new subset
            int current = arr[i];

            // Move to the next number as long as it's consecutive
            while (i < n && arr[i] == current) {
                i++;
                current++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {100, 56, 5, 6, 102, 58, 101, 57, 7, 103, 59};
        System.out.println(minConsecutiveSubsets(arr1)); // Output: 3

        int[] arr2 = {10, 100, 105};
        System.out.println(minConsecutiveSubsets(arr2)); // Output: 3
    }
}