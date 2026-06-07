// You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

// If isLefti == 1, then childi is the left child of parenti.
// If isLefti == 0, then childi is the right child of parenti.
// Construct the binary tree described by descriptions and return its root.

// The test cases will be generated such that the binary tree is valid.
public class createBinaryTreeFromDescriptions2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            TreeNode parentNode = map.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode childNode = map.getOrDefault(childVal, new TreeNode(childVal));

            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            map.put(parentVal, parentNode);
            map.put(childVal, childNode);
            children.add(childVal);
        }

        // The root is the one that is not a child of any node
        for (int key : map.keySet()) {
            if (!children.contains(key)) {
                return map.get(key);
            }
        }

        return null; // This line should never be reached if the input is valid
    }
}