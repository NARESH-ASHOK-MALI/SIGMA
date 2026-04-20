public class lastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {
        while (stones.length > 1) {
            Arrays.sort(stones);
            int x = stones[stones.length - 1];
            int y = stones[stones.length - 2];
            if (x == y) {
                stones = Arrays.copyOf(stones, stones.length - 2);
            } else {
                stones[stones.length - 2] = x - y;
                stones = Arrays.copyOf(stones, stones.length - 1);
            }
        }
        return stones.length == 0 ? 0 : stones[0];
    }
}
