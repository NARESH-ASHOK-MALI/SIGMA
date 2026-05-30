// Given an array arr[] of n integers, modify the array in-place such that each element is replaced with the XOR of its adjacent elements.

// For the first element, update arr[0] = arr[0] ^ arr[1].
// For the last element, update arr[n-1] = arr[n-2] ^ arr[n-1].
// For all other elements, update arr[i] = arr[i-1] ^ arr[i+1].
// Note: Here, a ^ b represents the XOR operation between a and b. 
public class ReplaceWithXOROfAdjacentElements {
    public void replaceWithXOR(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        int prev = arr[0];
        arr[0] = arr[0] ^ (n > 1 ? arr[1] : 0);

        for (int i = 1; i < n - 1; i++) {
            int current = arr[i];
            arr[i] = prev ^ arr[i + 1];
            prev = current;
        }

        if (n > 1) {
            arr[n - 1] = prev ^ arr[n - 1];
        }
    }
}