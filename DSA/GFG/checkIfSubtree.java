// Given two binary trees with roots root1 (for tree T) and root2 (for tree S), each containing at most N nodes. Determine whether tree S is a subtree of tree T.

// Return true if S is a subtree of T, otherwise return false.

// Note: A tree S is considered a subtree of T if there exists a node in T such that the subtree rooted at that node is identical to S. Two trees are identical if they have the same structure and the same node values.
class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        if (root2 == null) return true; // An empty tree is a subtree of any tree
        if (root1 == null) return false; // Non-empty tree cannot be a subtree of an empty tree
        
        if (areIdentical(root1, root2)) {
            return true;
        }
        
        // Check left and right subtrees of root1
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    private boolean areIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
    }
}
