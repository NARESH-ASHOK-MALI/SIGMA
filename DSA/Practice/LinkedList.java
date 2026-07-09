public class LinkedList{
    static int size=0;
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    // Add a new node at the start of the linked list
    public void addFirst(int data){

        // Create a new node with the given data
        Node newNode = new Node(data);

        // If the list is empty, set both head and tail to the new node
        if(head == null){
            head = tail = newNode;
            return;
        }

        // Point the next of the new node to the current head
        newNode.next = head; 

        // Update the head to be the new node
        head = newNode;
        size++;
    }

    public void addLast(int data){
        // Create a new node with the given data
        Node newNode = new Node(data);
        // If the list is empty, set both head and tail to the new node
        if(head == null){
            head = tail = newNode;
            return;
        }
        // Point the next of the current tail to the new node
        tail.next = newNode;
        // Update the tail to be the new node
        tail = newNode;
        size++;
    }
    public void printList(){
        // Start from the head of the list
        Node current = head;
        // Traverse the list and print each node's data
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        // Print "null" at the end to indicate the end of the list
        System.out.println("null");
    }
    public void add(int idx, int data){
        // Create a new node with the given data
        Node newNode = new Node(data);
        // If the list is empty, set both head and tail to the new node
        if(head == null){
            head = tail = newNode;
            return;
        }
        // Traverse the list to find the node at the specified index
        Node current = head;
        int count = 0;
        while(current != null && count < idx - 1){
            current = current.next;
            count++;
        }
        // If the index is out of bounds, do nothing
        if(current == null){
            return;
        }
        // Point the next of the new node to the next of the current node
        newNode.next = current.next;
        // Point the next of the current node to the new node
        current.next = newNode;
        size++;
    }
    public void removeFirst(){
        // If the list is empty, do nothing
        if(head == null){
            return;
        }
        // Update the head to be the next node
        head = head.next;
        size--;
    }
    public void removeLast(){
        // If the list is empty, do nothing
        if(head == null){
            return;
        }
        // If the list has only one node, set head and tail to null
        if(head.next == null){
            head = tail = null;
            size--;
            return;
        }
        // Traverse the list to find the second last node
        Node current = head;
        while(current.next != tail){
            current = current.next;
        }
        // Update the tail to be the second last node and set its next to null
        tail = current;
        tail.next = null;
        size--;
    }
    public void search(int key){
        // Start from the head of the list
        Node current = head;
        int index = 0;
        // Traverse the list to find the node with the given key
        while(current != null){
            if(current.data == key){
                System.out.println("Element found at index: " + index);
                return;
            }
            current = current.next;
            index++;
        }
        // If the key is not found, print a message
        System.out.println("Element not found in the list.");
    }
    public void searchRecursive(Node current, int key, int index){
        // Base case: if the current node is null, the key is not found
        if(current == null){
            System.out.println("Element not found in the list.");
            return;
        }
        // If the current node's data matches the key, print the index
        if(current.data == key){
            System.out.println("Element found at index: " + index);
            return;
        }
        // Recur for the next node and increment the index
        searchRecursive(current.next, key, index + 1);
    }
    public Node swapNodes(Node head, Node x, Node y) {
        // If x and y are the same, no need to swap
        if (x == y) {
            return head;
        }

        // Search for x (keep track of prevX and currX)
        Node prevX = null, currX = head;
        while (currX != null && currX != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, do nothing
        if (currX == null || currY == null) {
            return head;
        }

        // If x is not head of linked list
        if (prevX != null) {
            prevX.next = currY;
        } else { // make y the new head
            head = currY;
        }

        // If y is not head of linked list
        if (prevY != null) {
            prevY.next = currX;
        } else { // make x the new head
            head = currX;
        }

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return head;
    }

}