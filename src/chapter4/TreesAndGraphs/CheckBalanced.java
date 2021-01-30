package chapter4.TreesAndGraphs;

public class CheckBalanced {

    /**
     * Implement function to check if binary tree is balanced.
     *
     * Balanced tree is defined to be a tree such that the heights of the 2 subtrees of
     * any node never differ by more than one
     *
     * Idea: - use getHeight function to calc left and right subtree
     *       - if diff > 1: return false
     *       - else check left and right subtrees (recursive)
     *
     *  time: O(nlogn) since we have to check every node worst case
     */
    public int getHeight(TreeNode node) {
        if(node == null)
            return -1;

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public boolean isBalanced(TreeNode node) {
        if(node == null)
            return true;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        int diff = Math.abs(leftHeight - rightHeight);
        if(diff > 1)
            return false;
        else
            return isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * Better: modify getHeight function do return error if difference between left and right subtree > 1
     */
    public int checkHeight(TreeNode node) {
        if(node == null)
            return -1;

        int leftHeight = checkHeight(node.left);
        if(leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int rightHeight = checkHeight(node.right);
        if(rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int diff = Math.abs(leftHeight - rightHeight);
        if(diff > 1)
            return Integer.MIN_VALUE;

        return Math.max(rightHeight, leftHeight) + 1;
    }

    public boolean isBalancedFaster(TreeNode node) {
        return checkHeight(node) != Integer.MIN_VALUE;
    }
}
