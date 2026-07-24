// Given an array arr[ ] consisting of distinct integers, check if the given array can represent preorder traversal of a BST.

// Examples :

// Input: arr[] = [2, 4, 3]
// Output: true
// Explaination: Given arr[] can represent preorder traversal of following BST:
 
// Input: arr[] = [2, 4, 1]
// Output: false
// Explaination: Given arr[] cannot represent preorder traversal of a BST.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 0 ≤ arr[i] ≤ 105

class CheckPreorderBST {
    public boolean canRepresentBST(List<Integer> arr) {
        // Stack to simulate traversal
        Stack<Integer> stack = new Stack<>();
        
        // Root is initially the smallest possible value
        int root = Integer.MIN_VALUE;
        
        // Traverse the preorder list
        for (int value : arr) {
            // If we find a node smaller than allowed root, it's invalid
            if (value < root) return false;
            
            // Pop all ancestors smaller than current value
            while (!stack.isEmpty() && stack.peek() < value) {
                root = stack.pop();
            }
            
            // Push current value
            stack.push(value);
        }
        
        return true;
    }
}
