// Given a binary tree having n nodes, find the vertical sum of the nodes that are in the same vertical line. Return all sums through different vertical lines starting from the left-most vertical line to the right-most vertical line.
public class verticalSum {
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        dfs(root, 0, map);
        for (int sum : map.values()) {
            ans.add(sum);
        }
        return ans;
    }
    private void dfs(Node node, int col, Map<Integer, Integer> map) {
        if (node == null) return;
        map.put(col, map.getOrDefault(col, 0) + node.data);
        dfs(node.left, col - 1, map);
        dfs(node.right, col + 1, map);
    }
}
