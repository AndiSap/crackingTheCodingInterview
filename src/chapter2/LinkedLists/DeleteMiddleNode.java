package chapter2.LinkedLists;

import chapter2.LinkedLists.LinkedListBasics.Node;


public class DeleteMiddleNode {

    /**
     * Delete the node in the middle of singly linked list (between first and last node)
     * Assumption: head given
     */
    public void deleteMiddle(Node head) {
        Node p1 = head;
        Node p2 = head;

        while(p2 != null && p2.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
        }

        p1.data = p1.next.data;
        p1.next = p1.next.next;
    }

    /**
     * Delete middle node if only middle node is given
     */
    public void deleteMiddleNode(Node middle) {
        if(middle == null || middle.next == null) // given node is last node
            return;
        middle.data = middle.next.data;
        middle.next = middle.next.next;
    }
}
