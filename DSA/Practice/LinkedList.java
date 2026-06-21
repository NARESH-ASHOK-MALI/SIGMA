public class LinkedList{
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

}