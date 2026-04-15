public class friendPairingProb {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(friendPairing(n));
    }

    private static int friendPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return friendPairing(n - 1) + (n - 1) * friendPairing(n - 2);
    }
}