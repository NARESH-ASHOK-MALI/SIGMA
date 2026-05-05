// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

// You may return the answer in any order.
public class combinations {
    public static void main(String[] args) {
        combinations solution = new combinations();
        int n = 4, k = 2;
        List<List<Integer>> result = solution.combine(n, k);
        System.out.println(result); // Output: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            backtrack(result, tempList, i + 1, n, k);
            tempList.remove(tempList.size() - 1);
        }
    }
}
