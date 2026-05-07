// Given the root of a binary tree, return the size of the tree. The size of a binary tree is the total number of nodes in the tree.

public class SizeofBinaryTree {
   public int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    } 
}
