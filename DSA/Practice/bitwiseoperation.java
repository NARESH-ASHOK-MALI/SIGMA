import java.util.*;
public class bitwiseoperation {

    public static int getIthBit(int n, int i) {
        int mask = 1 << i; // Create a mask by left-shifting 1 by i positions
        return (n & mask) > 0 ? 1 : 0; // Use bitwise AND to check if the ith bit is set
    }
    public static int setIthBit(int n, int i) {
        int mask = 1 << i; // Create a mask by left-shifting 1 by i positions
        return n | mask; // Use bitwise OR to set the ith bit
    }
    public static int clearIthBit(int n, int i) {
        int mask = ~(1 << i); // Create a mask by left-shifting 1 by i positions and then negating it
        return n & mask; // Use bitwise AND to clear the ith bit
    }
    public static int updateIthBit(int n, int i, int v) {
        int mask = ~(1 << i); // Create a mask to clear the ith bit
        n = n & mask; // Clear the ith bit
        int valueMask = v << i; // Shift the value v to the correct position
        return n | valueMask; // Set the ith bit to v
    }
    public static int clearLastIBits(int n, int i) {
        int mask = ~((1 << i) - 1); // Create a mask to clear the last i bits
        return n & mask; // Use bitwise AND to clear the last i bits
    }
    public static int clearRangeOfBits(int n, int i, int j) {
        int maskA = ~0 << (j + 1); // Create a mask to clear bits from j+1 to the end
        int maskB = (1 << i) - 1; // Create a mask to clear bits from the start to i-1
        int mask = maskA | maskB; // Combine the two masks
        return n & mask; // Use bitwise AND to clear the range of bits from i to j
    }
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0; // A number is a power of two if it has only one bit set
    }
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1; // Increment count if the least significant bit is set
            n >>= 1; // Right-shift n to check the next bit
        }
        return count;
    }
    public static int fastExponentiation(int a, int n) {
        int result = 1;
        while (n > 0) {
            if ((n & 1) == 1) { // If n is odd, multiply the result by a
                result *= a;
            }
            a *= a; // Square a
            n >>= 1; // Right-shift n to divide it by 2
        }
        return result;
    }
    public static int swapNumbers(int a, int b) {
        a = a ^ b; // Step 1: a now holds the result of a XOR b
        b = a ^ b; // Step 2: b now holds the original value of a
        a = a ^ b; // Step 3: a now holds the original value of b
        return (a << 16) | (b & 0xFFFF); // Combine a and b into a single integer for return
    }
    public static void main(String[] args) {
        System.out.println(getIthBit(5, 2)); // Output: 0
        System.out.println(setIthBit(5, 2)); // Output: 5
        System.out.println(clearIthBit(5, 2)); // Output: 1
    }
}