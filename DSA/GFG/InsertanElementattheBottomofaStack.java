// You are given a stack st of n integers and an element x. You have to insert x at the bottom of the given stack. 

// Note: Everywhere in this problem, the bottommost element of the stack is shown first while priniting the stack.

// Example 1:

// Input:
// n = 5
// x = 2
// st = {4,3,2,1,8}
// Output:
// {2,4,3,2,1,8}
// Explanation:
// After insertion of 2, the final stack will be {2,4,3,2,1,8}.
// Example 2:

// Input:
// n = 3
// x = 4
// st = {5,3,1}
// Output:
// {4,5,3,1}
// Explanation:
// After insertion of 4, the final stack will be {4,5,3,1}.
public class InsertanElementattheBottomofaStack{
    public static void insertAtBottom(Stack<Integer> st, int x) {
        // Base case: If the stack is empty, push the element x
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        // Pop the top element and store it
        int topElement = st.pop();

        // Recursive call to insert x at the bottom of the remaining stack
        insertAtBottom(st, x);

        // Push the stored top element back onto the stack
        st.push(topElement);
    }
}