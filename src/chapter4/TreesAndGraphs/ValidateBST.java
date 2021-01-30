package chapter4.TreesAndGraphs;

/**
 * Check if binary tree is a binary search tree
 */
public class ValidateBST {

    /**
     * First approach, only if no duplicates exists!
     */
    int index = 0;
    public void createArray(TreeNode node, int[] array) {
        if(node == null)
            return;

        createArray(node.left, array);
        array[index] = node.data;
        index++;
        createArray(node.right, array);
    }

    public boolean isValidBst(TreeNode node) {
        int[] array = new int[node.size()];
        createArray(node, array);
        for(int i = 1; i < array.length; i++)
            if(array[i] <= array[i - 1])
                return false;

        return true;
    }

    /**
     * Second approach, validate tree as we do in-order traversal by saving last seen node
     */
    Integer lastSeen = null;
    public boolean isValid(TreeNode node) {
        if(node == null)
            return true;

        // check left side -> return false if false
        boolean left = isValidBst(node.left);
        if(!left) return false;

        // see if lastSeen <= current -> return false
        if(lastSeen != null && lastSeen >= node.data)
            return false;

        lastSeen = node.data;

        // check right side -> return false if false
        boolean right = isValidBst(node.right);
        if(!right) return false;

        // else valid tree
        return true;
    }

    /**
     * Third approach: Maintain left <= current < right
     */
    public boolean isValidBinarySearchTree(TreeNode node) {
        return isValidBinarySearchTree(node, null, null);
    }

    public boolean isValidBinarySearchTree(TreeNode node, Integer min, Integer max) {
        if(node == null) return true;

        // check if current node is within range -> if no return false
        if((min != null && node.data <= min) || (max != null && max < node.data))
            return false;

        // if we go left -> update max to current
        boolean left = isValidBinarySearchTree(node.left, min, node.data);
        // if left is false -> return false
        if(!left) return false;

        // if we go right -> update min to current
        boolean right = isValidBinarySearchTree(node.right, node.data, max);
        // if right is false -> return false
        if(!right) return false;

        // else it's a valid tree
        return true;
    }

}
