package chapter4.TreesAndGraphs;

/**
 * Find common ancestor of 2 nodes in a binary tree (not a BST)
 */
public class FindCommonAncestor {

    /**
     * Assumption: each node has also a parent node reference
     *
     * time: O(d)
     */
    public TreeNode compareAncestor(TreeNode node1, TreeNode node2) {
        // get eventual difference in depth
        int depth1 = depth(node1);
        int depth2 = depth(node2);
        int diff = Math.abs(depth1 - depth2);

        // move up deeper node by difference
        TreeNode first = depth1 <= depth2 ? node1 : node2;
        TreeNode second = depth1 <= depth2 ? node2 : node1;
        second = goUpBy(second, diff);

        // go up each level and compare both nodes
        while(first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        if(first == second && first != null) return first;
        return null;
    }

    public int depth(TreeNode node) {
        int depth = 0;
        while(node != null) {
            node = node.parent;
            depth++;
        }

        return depth;
    }

    public TreeNode goUpBy(TreeNode node, int offset) {
        while(offset > 0 && node != null) {
            node = node.parent;
            offset--;
        }
        return node;
    }

    /**
     * Another approach: start at one node and check if sibling node covers the second node
     */
    public TreeNode commonAncestorOptimized(TreeNode root, TreeNode node1, TreeNode node2) {
        if(!covers(root, node1) || !covers(root, node2)) return null;
        else if(covers(node1, node2)) return node1;
        else if(covers(node2, node1)) return node2;

        TreeNode sibling = getSibling(node1);
        TreeNode parent = node1.parent;
        while(!covers(sibling, node2)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    public boolean covers(TreeNode root, TreeNode node) {
        if(root == null) return false;
        if(root == node) return true;
        return covers(root.left, node) || covers(root.right, node);
    }

    public TreeNode getSibling(TreeNode node) {
        if(node == null || node.parent == null) return null;

        TreeNode parent = node.parent;
        if(parent.left == node) return parent.right;
        return parent.left;
    }
}
