//Given the head of a singly linked list, reverse the list, and return the reversed list.
public class reverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = reverseList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // Store the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move prev to the current node
            current = nextTemp; // Move to the next node
        }
        return prev; // At the end, prev will be the new head of the reversed list
    }
}
