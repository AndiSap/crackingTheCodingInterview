package chapter4.TreesAndGraphs;

public class MinimalBST {

    /**
     * Given sorted (increasing order) array with unique integer elements, create BST with minimal height
     *
     * - create middle element
     * - insert into left subtree the left subarray elements
     * - insert into right subtree the right subarray elements
     * - do this recursively
     */
    public TNode createMinimalBST(int[] array) {
        return createMinBST(array, 0, array.length - 1);
    }

    public TNode createMinBST(int[] array, int start, int end) {
        if(end < start)
            return null;

        // calculate middle
        int middle = (start + end) / 2;
        TNode root = new TNode(array[middle]);
        root.left = createMinBST(array, start, middle - 1);
        root.right = createMinBST(array, middle + 1, end);
        return root;
    }
}

class TNode {
    public int value;
    public TNode left;
    public TNode right;

    public TNode(int val) {
        this.value = val;
    }
}
