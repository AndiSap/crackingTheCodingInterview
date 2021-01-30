package chapter4.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListsOfDepths {

    /**
     * Given a binary tree, create linked lists of all nodes at each depth
     *
     * DFS and pre-traversal version
     */
    public void createLevelsDfs(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int depth) {
        if(root == null)
            return;

        LinkedList<TreeNode> currentList = null;
        if(lists.size() == depth) { // current level is missing!
            currentList = new LinkedList<>();
            lists.add(currentList);
        } else {
            currentList = lists.get(depth);
        }

        currentList.add(root);
        createLevelsDfs(root.left, lists, depth + 1);
        createLevelsDfs(root.right, lists, depth + 1);
    }

    public ArrayList<LinkedList<TreeNode>> createLevelDfs(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelsDfs(root, lists, 0);
        return lists;
    }

    /**
     * Use BFS (iterative version)
     */
    public ArrayList<LinkedList<TreeNode>> createLevelsBfs(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root != null)
            current.add(root);

        while(current.size() > 0) {
            lists.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            // visit all children
            for(TreeNode parent : parents) {
                if(parent.left != null)
                    current.add(parent.left);
                if(parent.right != null)
                    current.add(parent.right);
            }
        }

        return lists;
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;
}
