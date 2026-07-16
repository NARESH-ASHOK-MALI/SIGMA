// You are given an integer n. Your task is to compute the GCD (greatest common divisor) of two values:

// sumOdd: the sum of the smallest n positive odd numbers.

// sumEven: the sum of the smallest n positive even numbers.

// Return the GCD of sumOdd and sumEven.

 

// Example 1:

// Input: n = 4

// Output: 4

// Explanation:

// Sum of the first 4 odd numbers sumOdd = 1 + 3 + 5 + 7 = 16
// Sum of the first 4 even numbers sumEven = 2 + 4 + 6 + 8 = 20
// Hence, GCD(sumOdd, sumEven) = GCD(16, 20) = 4.

// Example 2:

// Input: n = 5

// Output: 5

// Explanation:

// Sum of the first 5 odd numbers sumOdd = 1 + 3 + 5 + 7 + 9 = 25
// Sum of the first 5 even numbers sumEven = 2 + 4 + 6 + 8 + 10 = 30
// Hence, GCD(sumOdd, sumEven) = GCD(25, 30) = 5.

 

// Constraints:

// 1 <= n <= 10​​​​​​​00
public class GCDOfOddAndEvenSums3658 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int computeGCD(int n) {
        // Calculate sum of first n odd numbers
        int sumOdd = n * n; // Sum of first n odd numbers is n^2

        // Calculate sum of first n even numbers
        int sumEven = n * (n + 1); // Sum of first n even numbers is n*(n+1)

        // Return GCD of sumOdd and sumEven
        return gcd(sumOdd, sumEven);
    }

    public static void main(String[] args) {
        int n1 = 4;
        System.out.println("GCD for n = " + n1 + ": " + computeGCD(n1)); // Output: 4

        int n2 = 5;
        System.out.println("GCD for n = " + n2 + ": " + computeGCD(n2)); // Output: 5
    }
}