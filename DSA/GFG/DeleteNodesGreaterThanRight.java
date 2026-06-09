// Given a singly linked list, remove all nodes that have a node with a greater value anywhere to their right in the list. Return the head of the modified linked list.

class DeleteNodesGreaterThanRight {
    public Node removeNodes(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the linked list
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;

        // Remove nodes that have a greater value to their right
        Node maxNode = head;
        current = head.next;
        while (current != null) {
            if (current.data < maxNode.data) {
                maxNode.next = current.next; // Remove current node
            } else {
                maxNode = current; // Update maxNode
            }
            current = current.next;
        }

        // Reverse the linked list back to original order
        prev = null;
        current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev; // New head of the modified linked list
    }
}