package chapter2.LinkedLists;

import chapter2.LinkedLists.LinkedListBasics.Node;

import java.util.LinkedList;

public class Palindrome {

    /**
     * Check if linked list is palindrome
     * i.e. 1 -> 2 -> 3 -> 2 -> 1
     * First approach: reverse list and check original and reverse
     * NOTE: we dont have to compare for entire length (half is enough) since 1st half original = 2nd half reversed
     */
    public boolean checkPalindrome(Node node) {
        // reverse list
        Node reverse = reverseList(node);
        // check every element in reverse list of equality
        return isEqual(node, reverse);
    }

    public Node reverseList(Node node) {
        Node reversed = null;

        while(node != null) {
            Node before = new Node(node.data);
            before.next = reversed;
            reversed = before;
            node = node.next;
        }

        return reversed;
    }

    public boolean isEqual(Node node, Node reverse) {
        while(node != null && reverse != null) {
            if(node.data != reverse.data)
                return false;

            node = node.next;
            reverse = reverse.next;
        }

        return true;
    }

    /**
     * Check using 2 pointers
     */
    public boolean checkPalindrome2Pointers(Node node) {
        // init 2 pointers, current and runner
        Node current = node;
        Node runner = node.next;

        // init stack
        LinkedList<Integer> stack = new LinkedList<>();
//        stack.add(current.data);

        // when 2nd pointer reaches middle, pop off stack and compare
        while(runner != null) {
            stack.add(current.data);
            current = current.next;
            runner = runner.next;
            runner = runner == null ? null : runner.next;
        }

        current = current.next;
        boolean isOddSize = false;
        while(current != null) {
            int element = stack.pollLast();
            if(element != current.data) {
                if(isOddSize)
                    return false;
                isOddSize = true;
                continue;
            }

            current = current.next;
        }

        return true;

    }

    /**
     * Recursive approach
     * Recurse until middle of list, then return node where recursion stopped
     * Every completed recursion step, we then check if returned node is equals current node
     * i.e i == n - i
     * if so, re return the next node and set result to true
     */
    public boolean checkRecursive(Node node) {
        int length = length(node);
        Data sol = recursive(node, length);
        return sol.result;
    }

    public Data recursive(Node node, int length) {
        if(node == null || length == 0) // linked list is even sized
            return new Data(node, true);
        else if(length == 1) // linked list is odd sized
            return new Data(node.next, true);


        Data res = recursive(node.next, length - 2);
        if(!res.result || res.node == null)
            return res;

        res.result = (res.node.data == node.data);
        res.node = res.node.next;
        return res;
    }

    class Data {
        public Node node;
        public boolean result;

        public Data(Node node, boolean res) {
            this.node = node;
            this.result = res;
        }
    }

    public int length(Node node) {
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }

        return length;
    }
}
