package chapter2.LinkedLists;

import chapter2.LinkedLists.LinkedListBasics.Node;

public class KtoLast {

    /**
     * Find the kth to last element of singly linked list
     * Trivial solution
     */
    public Node findKToLast(Node head, int k) {
        int length = 0;
        Node current = head;
        while(current != null) {
            length++;
            current = current.next;
        }

        current = head;
        int index = 0;
        while(current != null) {
            index++;
            if(index == length - k)
                return current;

            current = current.next;
        }

        return current;
    }

    /**
     * Recursive solution, only prints node element
     */
    public int kToLastRecursive(Node head, int k) {
        if(head == null)
            return -1;

        int current = kToLastRecursive(head.next, k) + 1;
        if(current == k)
            System.out.println("LinkedLists: found k to last element: " + head.data);

        return current;
    }

    /**
     * Recursive solution that returns kth node element
     * This way we update both index and node
     */
    static int index = 0;
    public Node ktoLastNode(Node head, int k) {
        if(head == null)
            return null;

        Node node = ktoLastNode(head.next, k);
        index += 1;
        if(index == k)
            return head;

        return node;
    }

    /**
     * Iterative solution with 2 pointers
     */
    public Node kToLastWithPointers(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        for(int i = 0; i < k; i++) // initialize p1 k steps ahead
            p1 = p1.next;

        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
