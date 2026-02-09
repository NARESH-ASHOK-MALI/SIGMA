import java.util.*;
public class sorting {
    public static void bubbleSort(int[] arr) { //O(n^2)
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int swaps = 0;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
            }
            }
            if (swaps == 0) {
                break; // No swaps means the array is already sorted
            }
        }
    }

    public static void selectionSort(int[] arr) { //O(n^2)
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void insertionSort(int[] arr) { //O(n^2)
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void countingSort(int[] arr) { //O(n+k) where k is the range of the input
        int largest = Integer.MIN_VALUE;
        for (int i : arr) {
            largest = Math.max(largest, i);
        }
        int count[] = new int[largest + 1];
        for (int i : arr) {
            count[i]++;
        }
        //sorting
        int j = 0;
        for (int i = 1; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }   

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        // bubbleSort(arr);
        // System.out.println("Sorted array: ");
        Arrays.sort(arr);// built in sort O(n log n) Arrays.sort(arr, si, ei)
        printArray(arr);
    }
}
