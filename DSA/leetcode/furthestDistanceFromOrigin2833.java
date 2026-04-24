public class furthestDistanceFromOrigin2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, underscore = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'L') left++;
            else if (ch == 'R') right++;
            else underscore++;
        }

        return Math.abs(left - right) + underscore;
    }
}
