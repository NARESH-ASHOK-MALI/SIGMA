// You are given a stack st[]. You have to reverse the stack.

// Note: The input array represents the stack from bottom to top (last element is the top). The output is displayed by printing elements from top to bottom after reversal.

// Examples:

// Input: st[] = [1, 2, 3, 4]
// Output: [1, 2, 3, 4]
// Explanation: After reversing, the elements of stack are in opposite order.

// Input: st[] = [3, 2, 1]
// Output: [3, 2, 1]
// Explanation: After reversing, the elements of stack are in opposite order.

// Constraints:
// 1 ≤ st.size() ≤ 100
// 0 ≤ stack element ≤ 100
public class reverseaStack {

    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()){
            return;
        }
        int top= st.pop();
        reverseStack(st);
        insertAtBottom(st,top);
    }
    public static void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }
        int topElement = st.pop();
        insertAtBottom(st, x);

        st.push(topElement);
    }
}
