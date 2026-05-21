// Given a number n, check whether every bit in the binary representation of the given number is set or not.

// Return true if yes, otherwise false.
public class checkifAllBitsSet {
    public boolean checkAllBitsSet(int n) {
        // code here
        if (n <= 0) return false; // No bits set for non-positive numbers

        // Check if n is of the form 2^k - 1, which means all bits are set
        return (n & (n + 1)) == 0;
    }
}
