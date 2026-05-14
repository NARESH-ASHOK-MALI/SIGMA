// You are given the root of a binary tree that consists of exactly 3 nodes: the root, its left child, and its right child.

// Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.
public class RootEqualsSumofChildren {
    public static void main(String [] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        System.out.println(checkTree(root));
    }
    public static boolean checkTree(TreeNode root) {
        if (root == null) {
            return false; // If the tree is empty, return false
        }
        
        int leftValue = (root.left != null) ? root.left.val : 0; // Get left child value or 0 if it doesn't exist
        int rightValue = (root.right != null) ? root.right.val : 0; // Get right child value or 0 if it doesn't exist
        
        return root.val == (leftValue + rightValue); // Check if root value equals the sum of left and right child values
    }
}
