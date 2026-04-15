//Apply Merge sort to sort an array of Strings.(Assume that all the characters in all the Strings are in lowercase).
public class dc1 {
    public static void main(String[] args) {
        // Input array of words to be sorted in lexicographical (dictionary) order.
        String[] arr = {"banana", "apple", "grape", "orange", "kiwi"};

        // Sort the full array using merge sort.
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: ");
        // Print each string after sorting.
        for (String str : arr) {
            System.out.print(str + " ");
        }
    }

    public static void mergeSort(String[] arr, int left, int right) {
        // Base condition: one element (or empty range) is already sorted.
        if (left < right) {
            // Find middle index to split array into two halves.
            int mid = left + (right - left) / 2;

            // Recursively sort left half.
            mergeSort(arr, left, mid);
            // Recursively sort right half.
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves into one sorted segment.
            merge(arr, left, mid, right);
        }
    }

    public static void merge(String[] arr, int left, int mid, int right) {
        // Sizes of temporary subarrays.
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays to store left and right parts.
        String[] L = new String[n1];
        String[] R = new String[n2];

        // Copy data into left temporary array.
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        // Copy data into right temporary array.
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // i -> index for L, j -> index for R, k -> index for original array.
        int i = 0, j = 0, k = left;

        // Compare elements from both halves and place smaller one into arr.
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from L, if any.
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements from R, if any.
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}
