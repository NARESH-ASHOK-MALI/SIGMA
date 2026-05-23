// Given a root of a binary tree with n nodes, where each node may contain positive or negative values, convert it into a tree such that each node’s new value is equal to the sum of all values in its left and right subtrees (based on the original tree). For leaf nodes, update their values to 0.
/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
public class transformToSumtree {
    private int convertToSumTree(Node root) {
        if (root == null) return 0;

        int oldValue = root.data;

        int leftSum = convertToSumTree(root.left);
        int rightSum = convertToSumTree(root.right);

        root.data = leftSum + rightSum;

        return root.data + oldValue;
    }

    public void toSumTree(Node root) {
        convertToSumTree(root);
    }
}