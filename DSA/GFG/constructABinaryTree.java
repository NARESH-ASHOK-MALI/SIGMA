// Given two arrays pre[] and preMirror[] of size n containing unique elements, where pre[] represents the preorder traversal of a full binary tree and preMirror[] represents the preorder traversal of its mirror tree, construct the original full binary tree using these traversals.

// Note: A general binary tree cannot be uniquely constructed using these two traversals. However, a full binary tree can be constructed uniquely from the given traversals without any ambiguity.

// Examples:

// Input: pre[] = [0,1,2], preMirror[] = [0,2,1] 
// Output: [0, 1, 2]
// Explanation: The tree will look like

       
// Input: pre[] = [1, 2, 4, 5, 3, 6, 7], preMirror[] = [1, 3, 7, 6, 2, 5, 4]
// Output: [1, 2, 4, 5, 3, 6, 7]
// Explanation: The tree will look like


// Constraints:

// 1 ≤ pre.size() ≤ 105
// 0 ≤ pre[i] ≤ 109
// 1 ≤ preMirror.size() ≤ 105
// 0 ≤ preMirror[i] ≤ 109
public class constructABinaryTree{
    int preIndex = 0;   // index for preorder
    int preMirrorIndex = 0; // index for preMirror
    
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        int n = pre.length;
        return build(pre, preMirror, 0, n - 1, n);
    }
    
    private Node build(int[] pre, int[] preMirror, int l, int r, int n) {
        if (preIndex >= n || l > r) return null;
        
        // Create root from preorder
        Node root = new Node(pre[preIndex++]);
        
        // If leaf node, return
        if (l == r) return root;
        
        // Find next element of preorder in preMirror
        int i;
        for (i = l; i <= r; i++) {
            if (pre[preIndex] == preMirror[i]) break;
        }
        
        // Build left and right subtrees
        if (i <= r) {
            root.left = build(pre, preMirror, i, r, n);
            root.right = build(pre, preMirror, l + 1, i - 1, n);
        }
        
        return root;
    }
}
