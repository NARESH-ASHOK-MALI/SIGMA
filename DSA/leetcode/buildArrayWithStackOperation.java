public class buildArrayWithStackOperation {
    public static void main(String[] args) {
        int n = 5;
        int[] target = {1, 3};
        List<String> operations = buildArray(target, n);
        System.out.println("Operations: " + operations);
    }
    public static List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int currentNumber = 1;

        for (int num : target) {
            while (currentNumber < num) {
                operations.add("Push");
                operations.add("Pop");
                currentNumber++;
            }
            operations.add("Push");
            currentNumber++;
        }

        return operations;
    }
}
