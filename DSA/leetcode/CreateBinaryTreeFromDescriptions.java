// You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

// If isLefti == 1, then childi is the left child of parenti.
// If isLefti == 0, then childi is the right child of parenti.
// Construct the binary tree described by descriptions and return its root.

// The test cases will be generated such that the binary tree is valid.
public class CreateBinaryTreeFromDescriptions {
    public static void main(String [] args){
        int[][] descriptions = {{20,15,1},{20,17,0},{50,19,1},{50,80,0},{19,18,1}};
        TreeNode root = createBinaryTree(descriptions);
        // You can add code here to print the tree or verify its structure
    }
    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));

            if (isLeft) {
                nodeMap.get(parentVal).left = nodeMap.get(childVal);
            } else {
                nodeMap.get(parentVal).right = nodeMap.get(childVal);
            }

            children.add(childVal);
        }

        // The root is the one that is not a child of any other node
        for (int parent : nodeMap.keySet()) {
            if (!children.contains(parent)) {
                return nodeMap.get(parent);
            }
        }

        return null; // This should never happen if the input is valid
    }
}
