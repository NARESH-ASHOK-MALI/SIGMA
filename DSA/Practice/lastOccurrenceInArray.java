public class lastOccurrenceInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Change this array to test with different values
        int target = 3; // Change this value to find the last occurrence of a different element
        int result = lastOccurrence(arr, target, arr.length - 1);
        if (result != -1) {
            System.out.println("The last occurrence of " + target + " is at index: " + result);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }

    public static int lastOccurrence(int[] arr, int target, int i) {
        if (i < 0) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        }
        return lastOccurrence(arr, target, i - 1);
    }

}
