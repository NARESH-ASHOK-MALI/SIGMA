public class TestCheckSubsetSumDivisibleByK {
    public static void main(String[] args) {
        int[] arr1 = {3,1,7,5};
        System.out.println(CheckSubsetSumDivisibleByK.isSubsetSumDivisibleByK(arr1, 6)); // true

        int[] arr2 = {1,2,6};
        System.out.println(CheckSubsetSumDivisibleByK.isSubsetSumDivisibleByK(arr2, 5)); // false

        int[] arr3 = {9};
        System.out.println(CheckSubsetSumDivisibleByK.isSubsetSumDivisibleByK(arr3, 7)); // false
    }
}
