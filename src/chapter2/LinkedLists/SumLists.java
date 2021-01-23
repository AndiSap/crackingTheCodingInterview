package chapter2.LinkedLists;

import chapter2.LinkedLists.LinkedListBasics.Node;

public class SumLists {

    /**
     * Sum 2 numbers given as linked lists where digits are stored in reverse order
     * i.e. 5 -> 1 -> 6 = 615
     */
    public Node sumLists(Node list1, Node list2) {
        Node sum = list1;
        Node head = sum;

        int carry = 0;
        while(list1 != null || list2 != null) {

            if(list1 == null) {
                sum.data = list2.data;
            } else if(list2 == null) {
                sum.data = list1.data;
            } else {
                int raw = list1.data + list2.data;
                sum.data = (raw % 10) + carry;
                carry = raw / 10;
            }

            list1 = list1 != null ? list1.next : list1;
            list2 = list2 != null ? list2.next : list2;
            sum = sum.next;
        }

        return head;
    }

    /**
     * Recursive sum 2 given linked lists (which are in reverse order)
     * i.e. 5 -> 1 -> 6 = 615
     * Idea: Have carry over as parameter since its shared and return
     *       new created list
     */
    public Node add2Lists(Node list1, Node list2) {
        return add2Lists(list1, list2, 0);
    }

    public Node add2Lists(Node list1, Node list2, int carry) {
        // base case
        if(list1 == null && list1 == null && carry == 0)
            return null;
        // create new node and add both list nodes
        Node result = new Node(0);

        int value = carry;
        if(list1 != null)
            value += list1.data;
        if(list2 != null)
            value += list2.data;
        result.data = value % 10;

        // recurse over next list elements and add result to created list node and return
        if(list1 != null || list2 != null) {
            list1 = list1 != null ? list1 : null;
            list2 = list2 != null ? list2 : null;
            Node next = add2Lists(list1.next, list2.next, value > 10 ? 1 : 0);
            result.next = next;
        }
        return result;
    }

    /**
     * Recursive sum 2 given linked lists which are in forward order
     * i.e. 5 -> 1 -> 6 = 516
     */
    public Node add2ListsForward(Node list1, Node list2) {
        // check if unequal sizes -> pad shorter list
        int length1 = length(list1);
        int length2 = length(list2);

        if(length1 < length2)
            list1 = padList(list1, length2 - length1);
        else
            list2 = padList(list2, length1 - length2);

        // recursively call helper function which has carry as params and returns solution list
        PartialSum result = addListsHelper(list1, list2);

        if(result.carry != 0) { // if there is a number to carry over, add as new node to beginning of list
            Node solution = insertBefore(result.node, result.carry);
            return solution;
        }

        return result.node;
    }

    class PartialSum { // stores sum node and carry value
        public Node node = null;
        public int carry = 0;
    }

    public int length(Node node) {
        if(node == null)
            return 0;

        return length(node.next) + 1;
    }

    public Node insertBefore(Node node, int data) {
        Node head = new Node(data);
        if(node != null)
            head.next = node;
        return head;
    }

    public Node padList(Node list, int padding) {
        Node head = list;
        for(int i = 0; i < padding; i++)
            head = insertBefore(head, 0);

        return head;
    }

    // recursively call itself and add sum of current node elements
    public PartialSum addListsHelper(Node list1, Node list2) {
        // base case
        if(list1 == null && list2 == null)
            return new PartialSum();

        PartialSum result = addListsHelper(list1.next, list2.next);
        int value = list1.data + list2.data + result.carry;

        result.node = insertBefore(result.node, value % 10); // add current node to list
        result.carry =  value / 10;

        return result;
    }

}
