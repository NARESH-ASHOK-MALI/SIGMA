// Given an array arr[] containing distinct positive integers, and two integers start and end defining a range. Determine if the array contains all elements within inclusive range [start, end].

// Note: If the array contains all elements in the given range return true otherwise return false.
public class elementsInRange {
    public boolean containsAllElements(int[] arr, int start, int end) {
        // Create a set to store all elements in the array
        java.util.Set<Integer> elementSet = new java.util.HashSet<>();
        for (int num : arr) {
            elementSet.add(num);
        }

        // Check if all elements in the range [start, end] are present
        for (int i = start; i <= end; i++) {
            if (!elementSet.contains(i)) {
                return false;
            }
        }

        return true;
    }
}
