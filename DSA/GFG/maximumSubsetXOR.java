// Given an array arr[], choose any subset of elements (possibly all elements) such that the XOR of the chosen elements is maximized.

// Examples:

// Input : arr[] = [2, 4, 5]
// Output: 7
// Explanation: The subset {2, 5} has the maximum XOR value.
// Input : arr[] = [9, 8, 5]
// Output: 13
// Explanation: The subset {8, 5} has the maximum XOR value.
// Constraints:

// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 106
class  maximumSubsetXOR {
    public int maxSubsetXOR(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];  // ✅ handle single-element case

        int index = 0;

        // Process bits from MSB to LSB
        for (int bit = 31; bit >= 0; bit--) {
            int maxIndex = -1;
            for (int j = index; j < n; j++) {
                if (((arr[j] >> bit) & 1) == 1) {
                    maxIndex = j;
                    break;
                }
            }

            if (maxIndex == -1) continue; // no element with this bit

            // Swap chosen element to current index
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;

            // Eliminate this bit from all other elements
            for (int j = 0; j < n; j++) {
                if (j != index && ((arr[j] >> bit) & 1) == 1) {
                    arr[j] ^= arr[index];
                }
            }

            index++;
        }

        // Compute maximum XOR from basis
        int result = 0;
        for (int i = 0; i < index; i++) {
            result = Math.max(result, result ^ arr[i]);
        }

        return result;
    }
}
