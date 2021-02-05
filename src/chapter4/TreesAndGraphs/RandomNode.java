package chapter4.TreesAndGraphs;

import java.util.Random;

/**
 * Implement BST from scratch which also has a method getRandomNode() which returns a random node with equal probability for all nodes
 */
public class RandomNode {

    class TreeNode {
        TreeNode left, right;
        int data;
        int size;

        public TreeNode(int data) {
            this.data = data;
            this.size = 1;
        }

        public TreeNode getRandomNode() {
            int leftSide = left != null ? left.size : 0;
            Random random = new Random();
            int randomInt = random.nextInt(size);

            if(leftSide < randomInt)
                return left.getRandomNode();
            if(leftSide == randomInt)
                return this;
            return right.getRandomNode();
        }

        public void insertNode(int num) {
            if(num <= data) {
                if(left == null)
                    left = new TreeNode(num);
                else
                    left.insertNode(num);
            } else {
                if(right == null)
                    right = new TreeNode(num);
                else
                    right.insertNode(num);
            }

            size++;
        }

        public TreeNode find(int num) {
            if(num == data)
                return this;
            if(num <= data)
                return left != null ? left.find(num) : null;
            return right != null ? right.find(num) : null;
        }
    }
}
