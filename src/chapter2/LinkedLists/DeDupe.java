package chapter2.LinkedLists;
import chapter2.LinkedLists.LinkedListBasics.Node;

import java.util.HashSet;

public class DeDupe {
    /**
     * Remove duplicates from an unsorted list
     * Assumptions: additional memory allowed, but no new linked list
     *              singly linked list
     */
    public void dedupe(Node head) {
        HashSet<Integer> map = new HashSet<>();
        Node current = head;
        map.add(current.data);
        while(current != null && current.next != null) {
            if(map.contains(current.next.data))
                current.next = current.next.next;
            else
                map.add(current.next.data);

            current = current.next;
        }
    }

    /**
     * Dedupe without additional memory
     * Use current pointer and runner pointer
     */
    public void dedupeRunner(Node head) {
        Node current = head;
        while(current != null) {
            Node runner = current;
            while(runner.next != null) {
                if(runner.next.data == current.data)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }
            current = current.next;
        }
    }
}
