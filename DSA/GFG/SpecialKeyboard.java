// Given a special keyboard that contains only four keys:

// Key 1: Prints a single character 'A' on the screen.
// Key 2 (Ctrl + A): Selects all the characters currently present on the screen.
// Key 3 (Ctrl + C): Copies the selected characters to a buffer.
// Key 4 (Ctrl + V): Pastes the content of the buffer onto the screen, appending it to the existing text.
// Initially, the screen is empty and the buffer is also empty.

// Determine the maximum number of 'A' characters that can be displayed on the screen after performing exactly n key presses.
public class SpecialKeyboard {
    public int maxA(int n) {
        if (n <= 0) return 0;
        if (n <= 6) return n;

        int[] dp = new int[n + 1];
        for (int i = 0; i <= 6 && i <= n; i++) dp[i] = i;

        for (int i = 7; i <= n; i++) {
            dp[i] = 0;
            // Try breakpoint j where we stop typing A and perform Ctrl-A, Ctrl-C, then multiple Ctrl-V
            for (int j = i - 3; j >= 1; j--) {
                int pastes = i - j - 2; // number of Ctrl-V presses after Ctrl-A and Ctrl-C
                int current = dp[j] * (pastes + 1); // original block plus pasted copies
                dp[i] = Math.max(dp[i], current);
            }
        }

        return dp[n];
    }
}
