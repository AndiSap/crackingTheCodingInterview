package chapter4.TreesAndGraphs;

public class Successor {

    /**
     * Find next in-order successor given a node in a valid BST
     */
    public TreeNode successor(TreeNode node) {
        if(node == null)
            return null;

        // if current node has right side -> get leftmost element of rigth side
        if(node.right != null) {
            TreeNode current = node.right;
            while(current.left != null)
                current = current.left;

            return current;
        } else {
            // otherwise, go one level up until current element is left child -> then return parent
            TreeNode current = node;
            TreeNode parent = node.parent;
            while(parent != null && current != parent.left) { // or current.data > parent.data
                current = parent;
                parent = parent.parent;
            }
            // else -> if current element is left child -> return parent
            return parent;
        }
    }
}
