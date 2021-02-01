package chapter4.TreesAndGraphs;

/**
 * Find common ancestor of 2 nodes in a binary tree (not a BST)
 */
public class FindCommonAncestor {

    // ------------------------- With link to parent --------------------------
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

    // ------------------------- Without link to parent --------------------------
    public TreeNode commonAncestorWithoutLink(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null) return null;
        if(!covers(root, node1) || !covers(root, node2))
            return null;

        return ancestorHelper(root, node1, node2);
    }

    /**
     * Time: O(n)
     * specifically O(2n) since we run cover on both left and right side
     */
    public TreeNode ancestorHelper(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null || node1 == null || node2 == null)
            return null;

        boolean node1Left = covers(root.left, node1); // is node1 in left subtree
        boolean node2Left = covers(root.left, node2); // is node2 in left subtree
        if(node1Left != node2Left) // if they are in different subtrees -> this is current ancestor!
            return root;

        TreeNode next = node1Left ? root.left : root.right;
        return ancestorHelper(next, node1, node2);
    }

    /**
     * Optimized with returning nodes
     */
    public TreeNode commonAncestorWithoutParentsOptimized(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null)
            return null;

        if(root == node1 && root == node2)
            return root;

        TreeNode left = commonAncestorWithoutParentsOptimized(root.left, node1, node2);
        if(left != null && left != node1 && left != node2) // already found common ancestor
            return left;

        TreeNode right = commonAncestorWithoutParentsOptimized(root.right, node1, node2);
        if(right != null && right != node1 && right != node2)
            return right;

        if(left != null && right != null)
            return root; // common ancestor
        else if(root == node1 || root == node1) {
            return root; // nodes are in subtrees
        } else {
            return right != null ? right : left;
        }
    }
}
