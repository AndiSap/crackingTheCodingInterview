package chapter2.LinkedLists;

public class LinkedListBasics {

    /**
     * Create a singly linked list
     * To have a linked list used by many applications, create Linked List class that wraps this Node class
     */
    public class Node {
        Node next = null;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public void appendToTail(int data) {
            Node nextNode = new Node(data);
            Node n = this;
            while(n.next != null)
                n = n.next;

            n.next = nextNode;
        }

        public Node deleteNode(Node head, int target) {
            if(head == null)
                return null;

            Node n = head;
            if(head.data == target) // head node equals target
                return head.next; // remove head node

            while(n.next != null) {
                if(n.next.data == target) {
                    n.next = n.next.next;
                    return head; // since head didn't change
                }
                n = n.next; // go to next node
            }

            return head;
        }
    }
}
