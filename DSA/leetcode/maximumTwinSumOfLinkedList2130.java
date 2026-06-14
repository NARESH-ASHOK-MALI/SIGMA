// In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

// For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
// The twin sum is defined as the sum of a node and its twin.

// Given the head of a linked list with even length, return the maximum twin sum of the linked list.
public class maximumTwinSumOfLinkedList2130{
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find the middle of the linked list using the slow and fast pointer technique
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Calculate the twin sums and find the maximum
        int maxTwinSum = 0;
        ListNode firstHalfPointer = head;
        ListNode secondHalfPointer = prev; // This is now the head of the reversed second half

        while (secondHalfPointer != null) {
            int twinSum = firstHalfPointer.val + secondHalfPointer.val;
            maxTwinSum = Math.max(maxTwinSum, twinSum);
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        return maxTwinSum;
    }
}