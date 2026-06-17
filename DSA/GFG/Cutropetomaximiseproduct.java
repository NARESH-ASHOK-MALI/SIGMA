// Given a rope of length n meters, cut it into multiple smaller ropes such that the product of their lengths is maximized. At least one cut is mandatory.
public class Cutropetomaximiseproduct{
    public int maxProduct(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int count3 = n / 3;
        int rem = n % 3;

        if (rem == 1) {
            count3--;
            return (int)Math.pow(3, count3) * 4;
        } else if (rem == 2) {
            return (int)Math.pow(3, count3) * 2;
        } else {
            return (int)Math.pow(3, count3);
        }
    }
}