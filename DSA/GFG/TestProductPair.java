public class TestProductPair {
    public static void main(String[] args) {
        productpair p = new productpair();
        test(p, new int[]{0,1}, 0, true);
        test(p, new int[]{0}, 0, false);
        test(p, new int[]{0,0}, 0, true);
        test(p, new int[]{2,4}, 8, true);
        test(p, new int[]{2,3,5}, 6, true);
        test(p, new int[]{2,3,5}, 7, false);
        test(p, new int[]{-2,-4}, 8, true);
        test(p, new int[]{-2,4}, -8, true);
        test(p, new int[]{3}, 9, false);
        test(p, new int[]{2,2}, 4, true);
        test(p, new int[]{1,-1}, -1, true);
    }

    static void test(productpair p, int[] arr, int target, boolean expected) {
        boolean actual = p.isProduct(arr, target);
        System.out.printf("arr=%s target=%d => expected=%b actual=%b\n", java.util.Arrays.toString(arr), target, expected, actual);
        if (actual != expected) {
            System.out.println("FAILED for above case");
        }
    }
}
