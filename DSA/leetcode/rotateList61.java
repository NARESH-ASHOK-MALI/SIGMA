// Given the head of a linked list, rotate the list to the right by k places.
public class rotateList61 {
    public static void main(String[] args) {
        rotateList61 solution = new rotateList61();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode result = solution.rotateRight(head, k);
        printList(result); // Output: 4 -> 5 -> 1 -> 2 -> 3
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // Compute the length of the list and get the tail node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        // Connect the tail to the head to make it circular
        tail.next = head;
        // Find the new tail: (length - k % length - 1)th node
        // and the new head: (length - k % length)th node
        int newTailIndex = length - k % length - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailIndex; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        // Break the circle
        newTail.next = null;
        return newHead;
    }
}
