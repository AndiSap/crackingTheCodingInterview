package chapter2.LinkedLists;

import chapter2.LinkedLists.LinkedListBasics.Node;

public class Partition {

    /**
     * Partition linked list around a value x
     */
    public Node partition(Node head, int target) {
        Node p1 = head; // elements less than target
        Node p2 = head; // elements greater or same as target
        Node startP1 = null;
        Node startP2 = null;

        Node current = head;
        while(current != null) {
            Node next = current.next;
            current.next = null;

            if(current.data < target) {
                if(startP1 == null) {
                    startP1 = current;
                    p1 = startP1;
                }
                else {
                    p1.next = current;
                    p1 = current;
                }
            } else {
                if(startP2 == null) {
                    startP2 = current;
                    p2 = startP2;
                } else {
                    p2.next = current;
                    p2 = current;
                }
            }

            current = next;
        }
        p2.next = null;

        p1.next = startP2;
        return startP1;
    }

    /**
     * Partition rearrange elements
     */
    public Node partitionRearrange(Node node, int target) {
        Node smaller = node;
        Node bigger = node;

        while(node != null) {
            Node next = node.next; // save remainder of list
            if(node.data < target) {
                node.next = smaller; // swaps element to next node has smaller element
                smaller = node; // sets current node
            } else {
                bigger.next = node;
                bigger = node; // sets current node
            }
            node = next;
        }

        bigger.next = null;
        return smaller;
    }
}
