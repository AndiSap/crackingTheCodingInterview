package chapter2.LinkedLists;

import chapter2.LinkedLists.LinkedListBasics.Node;

public class Intersects {

    /**
     * Determine if 2 singly linked lists intersect
     * Naive approach: time: O(A*B)
     */
    public Node intersect(Node list1, Node list2) {
        while(list1 != null) {
            Node runner = list2;
            while(runner != null) {
                if(runner == list1)
                    return runner;
                runner = runner.next;
            }
            list1 = list1.next;
        }
        return null;
    }

    /**
     * Better approach in O(A+B)
     * - check both lengths and tails
     * - compare tails -> if not equal -> lists don't intersect
     * - advance difference in lenghts on longer list
     * - go thru lists, once element references equal, return element
     */
    public Node findIntersection(Node list1, Node list2) {
        if(list1 == null || list2 == null)
            return null;

        Result l1 = getTailAndSize(list1);
        Result l2 = getTailAndSize(list2);

        if(l1.tail != l2.tail) // lists don't intersect
            return null;

        Node shorter = l1.size < l2.size ? list1 : list2;
        Node longer = l1.size < l2.size ? list2 : list1;

        longer = advanceToKthNode(longer, Math.abs(l1.size - l2.size));
        while(shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    class Result {
        Node tail;
        int size;

        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    public Result getTailAndSize(Node node) {
        int size = 1;
        while(node.next != null) { // we want to keep the tail node
            node = node.next;
            size++;
        }

        return new Result(node, size);
    }

    public Node advanceToKthNode(Node node, int advanceTo) {
        int currentIdx = 0;
        while(currentIdx != advanceTo && node != null) {
            node = node.next;
            currentIdx++;
        }

        return node;
    }
}
