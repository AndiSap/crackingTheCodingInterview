package chapter4.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequence {

    /**
     * Given a BST with distinct elements, print all possible arrays that could have led to this tree
     *
     * First: recurse through tree, for each level create weaves of left and right side
     * Second: Weave function that weaves 2 lists
     */
    public ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        // if node empty return empty list
        if(node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        // initialize prefix and add first element
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        // get left and right subtree recursively
        ArrayList<LinkedList<Integer>> leftSide = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSide = allSequences(node.right);

        // combine left and right solutions
        for(LinkedList<Integer> left : leftSide) {
            for(LinkedList<Integer> right : rightSide) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    public void weaveLists(LinkedList<Integer> left, LinkedList<Integer> right, ArrayList<LinkedList<Integer>> solution, LinkedList<Integer> prefix) {
        // if either list is 0, just add leftovers to solution
        if(left.size() == 0 || right.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone(); // do not manipulate original prefix
            result.addAll(left);
            result.addAll(right);
            solution.add(result);
            return;
        }

        // for both sides
        int next = left.getFirst();
        prefix.add(next);
        weaveLists(left, right, solution, prefix);
        prefix.removeLast();
        left.add(next);

        // get first el and add it to prefix -> call recursively and put back element
        next = right.getFirst();
        prefix.add(next);
        weaveLists(left, right, solution, prefix);
        prefix.removeLast();
        right.add(next);
    }
}
