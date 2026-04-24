//There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

//You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
public class largestAltitude {
    public int largestAltitude(int[] gain) {
        int count = 0;
        int[] arr = new int[gain.length + 1];
        arr[0] = 0;

        for (int i = 0; i < gain.length; i++) {
            count += gain[i];
            arr[i + 1] = count;
        }

        return getMax(arr);
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
