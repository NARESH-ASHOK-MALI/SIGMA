import java.util.Collections;
import java.util.PriorityQueue;

public class constructTargetArrayWithMutipleSum {
    public static void main(String[] args) {
        int[] target = {9, 3, 5};
        System.out.println(isPossible(target));
    }
    public static boolean isPossible(int[] target) {
        long sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : target) {
            sum += num;
            maxHeap.offer(num);
        }

        while (true) {
            int maxValue = maxHeap.poll();
            long restSum = sum - maxValue;

            if (maxValue == 1 || restSum == 1) {
                return true;
            }
            if (restSum == 0 || maxValue < restSum) {
                return false;
            }

            int newValue = (int) (maxValue % restSum);
            if (newValue == 0) {
                return false;
            }

            maxHeap.offer(newValue);
            sum = restSum + newValue;
        }
    }
}
