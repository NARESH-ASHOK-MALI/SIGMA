//Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

//The first node is considered odd, and the second node is even, and so on.

//Note that the relative order inside both the even and odd groups should remain as it was in the input.

//You must solve the problem in O(1) extra space complexity and O(n) time complexity.
public class oddEvenList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = oddEvenList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // To keep track of the head of even nodes

        while (even != null && even.next != null) {
            odd.next = even.next; // Link odd nodes together
            odd = odd.next; // Move odd pointer
            even.next = odd.next; // Link even nodes together
            even = even.next; // Move even pointer
        }
        odd.next = evenHead; // Connect the end of odd list to the head of even list
        return head;
    }
}
