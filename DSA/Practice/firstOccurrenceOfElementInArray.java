public class firstOccurrenceOfElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Change this array to test with different values
        int target = 3; // Change this value to find the first occurrence of a different element
        int result = firstOccurrence(arr, target, 0);
        if (result != -1) {
            System.out.println("The first occurrence of " + target + " is at index: " + result);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }

    public static int firstOccurrence(int[] arr, int target, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        }
        return firstOccurrence(arr, target, i + 1);
    }

}
