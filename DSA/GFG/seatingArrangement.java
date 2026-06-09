// Given an integer k representing the number of people to be seated and an array seats[], where 0 denotes an empty seat and 1 denotes an occupied seat.

// Determine whether it is possible to seat all k people such that no two occupied seats are adjacent (including newly seated people).
public class seatingArrangement {
    public static boolean canSeat(int[] seats, int k) {
        if (seats == null || seats.length == 0) return k <= 0;

        int n = seats.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                // Check for invalid adjacent seating
                if ((i > 0 && seats[i - 1] == 1) || (i < n - 1 && seats[i + 1] == 1)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                boolean leftEmpty = (i == 0 || seats[i - 1] == 0);
                boolean rightEmpty = (i == n - 1 || seats[i + 1] == 0);
                if (leftEmpty && rightEmpty) {
                    seats[i] = 1; // seat someone here
                    count++;
                }
            }
            if (count >= k) return true;
        }

        return count >= k;
    }
}
