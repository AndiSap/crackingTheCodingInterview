package chapter4.TreesAndGraphs;

public class TreesAndGraphsBasics {

    /**
     * Basics of trees:
     * - each tree has 1 root
     * - root node has 0 or more child nodes
     * - each child node has 0 or more child nodes...
     *
     * - tree cannot contain cycles & nodes may or may not be in particular order
     */

    /* Node definition */
    class Node {
        public String name;
        public Node[] children;
    }

    /* Could use tree class to wrap this node */
    class Tree {
        public Node root;
    }

}
