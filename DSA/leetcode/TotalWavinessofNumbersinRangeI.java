// You are given two integers num1 and num2 representing an inclusive range [num1, num2].

// The waviness of a number is defined as the total count of its peaks and valleys:

// A digit is a peak if it is strictly greater than both of its immediate neighbors.
// A digit is a valley if it is strictly less than both of its immediate neighbors.
// The first and last digits of a number cannot be peaks or valleys.
// Any number with fewer than 3 digits has a waviness of 0.
// Return the total sum of waviness for all numbers in the range [num1, num2].
public class TotalWavinessofNumbersinRangeI{
    public int totalWaviness(int num1, int num2) {
        int totalWaviness = 0;
        for (int i = num1; i <= num2; i++) {
            totalWaviness += calculateWaviness(i);
        }
        return totalWaviness;
    }
    private int calculateWaviness(int num) {
        String numStr = Integer.toString(num);
        int waviness = 0;
        for (int i = 1; i < numStr.length() - 1; i++) {
            char prev = numStr.charAt(i - 1);
            char curr = numStr.charAt(i);
            char next = numStr.charAt(i + 1);
            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                waviness++;
            }
        }
        return waviness;
    }
}