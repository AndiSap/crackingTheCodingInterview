package chapter2.LinkedLists;

import chapter2.LinkedLists.LinkedListBasics.Node;

public class LoopDetection {

    /**
     * Find if liked lst contains loop and return fist node in loop
     * Idea:
     * - slow pointer which moves at 1 step
     * - fast pointer which moves at 2 steps
     * - they will collide at k steps before start of loop (if there is a loop)
     * - reset fast pointer to head and 1 step
     * - slow and fast will collide at starting point of loop
     */
    public Node findBeginning(Node node) {
        Node slow = node;
        Node fast = node;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) // they are now k steps before beginning of loop
                break;
        }

        if(fast == null || fast.next == null) // linked list has no loops
            return null;

        fast = node;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
