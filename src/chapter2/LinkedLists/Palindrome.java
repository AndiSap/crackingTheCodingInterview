package chapter2.LinkedLists;

import chapter2.LinkedLists.LinkedListBasics.Node;

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
}
