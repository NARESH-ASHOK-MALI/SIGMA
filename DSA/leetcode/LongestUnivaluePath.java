// Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.

// The length of the path between two nodes is represented by the number of edges between them.
public class LongestUnivaluePath {
    public static void main(String [] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(longestUnivaluePath(root));
    }
    public static int longestUnivaluePath(TreeNode root) {
        int[] maxPath = new int[1]; // To keep track of the maximum path length
        longestPathHelper(root, maxPath);
        return maxPath[0];
    }
    private static int longestPathHelper(TreeNode node, int[] maxPath) {
        if (node == null) {
            return 0; // Base case: if the node is null, return 0
        }
        
        // Recursively find the longest path in the left and right subtrees
        int leftPath = longestPathHelper(node.left, maxPath);
        int rightPath = longestPathHelper(node.right, maxPath);
        
        // Initialize paths through the current node
        int leftUnivaluePath = 0;
        int rightUnivaluePath = 0;
        
        // Check if the left child has the same value as the current node
        if (node.left != null && node.left.val == node.val) {
            leftUnivaluePath = leftPath + 1; // Extend the path through the left child
        }
        
        // Check if the right child has the same value as the current node
        if (node.right != null && node.right.val == node.val) {
            rightUnivaluePath = rightPath + 1; // Extend the path through the right child
        }
        
        // Update the maximum path length found so far
        maxPath[0] = Math.max(maxPath[0], leftUnivaluePath + rightUnivaluePath);
        
        // Return the longest univalue path that can be extended to the parent
        return Math.max(leftUnivaluePath, rightUnivaluePath);
    }
}
