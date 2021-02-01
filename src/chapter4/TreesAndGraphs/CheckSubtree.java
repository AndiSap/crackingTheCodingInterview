package chapter4.TreesAndGraphs;

/**
 * Determine if T2 is subtree of T1 if T1 is much bigger than T2
 */
public class CheckSubtree {

    /**
     * First approach, print both pre-order traversal
     * -> if T2 is substring of T1, then also sub tree
     *
     * time: O(nm)
     * space: O(n + m)
     */
    public boolean isSubtree(TreeNode node1, TreeNode node2) {
        // setup strings
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        // generate strings via pre-order traversal
        runPreOrder(node1, string1);
        runPreOrder(node2, string2);

        // compare strings
        return string1.indexOf(string2.toString()) != -1;
    }

    public void runPreOrder(TreeNode node, StringBuilder string) {
        // if node empty -> add place holder
        if(node == null) {
            string.append("X");
            return;
        }

        // add current node
        string.append(node.data);

        // recurse thru left and right
        runPreOrder(node.left, string);
        runPreOrder(node.right, string);
    }

    /**
     * Variant 2: search T1 until we find root of T2
     * -> then run pre-order traversal and compare elements of T1 and T2
     *
     * worst case time: O(nm)
     * average case time: O(n + km), depending on how many k duplicates of root of smaller tree are in bigger tree
     * space: O(log(n) + log(m))
     */
    public boolean isSubTreeOptimized(TreeNode node1, TreeNode node2) {
        if(node2 == null)
            return true;

        return comapareTrees(node1, node2);
    }

    public boolean comapareTrees(TreeNode node1, TreeNode node2) {
        if(node1 == null)
            return false;

        // if node1.data equals node2.data and trees match -> return true
        if(node1.data == node2.data && matchTrees(node1, node2))
            return true;

        // otherwise recurse thru left and right of node1
        return comapareTrees(node1.left, node2) || comapareTrees(node1.right, node2);
    }

    public boolean matchTrees(TreeNode node1, TreeNode node2) {
        // if node1 or node2 == null -> return true;
        if(node1 == null || node2 == null)
            return true;

        // else if data is equal, recurse thru left and right on both trees
        if(node1.data == node2.data)
            return matchTrees(node1.left, node2.left) && matchTrees(node1.right, node2.right);

        // otherwise trees are not equal
        return false;
    }
}
