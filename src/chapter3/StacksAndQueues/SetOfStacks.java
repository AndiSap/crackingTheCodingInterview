package chapter3.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Creates new internal stack after some threshold is reached
 */
public class SetOfStacks {
    int threshold;
    ArrayList<java.util.Stack<Integer>> setOfStacks = new ArrayList<>();
    int stackSize = 0;

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
    }

    public void push(int data) {
        // create new stack if threshold reached or set empty
        java.util.Stack<Integer> current;
        if(stackSize == threshold || setOfStacks.size() == 0) {
            current = new java.util.Stack<>();
            setOfStacks.add(current);
            stackSize = 0;
        }
        else
            current = setOfStacks.get(setOfStacks.size() - 1);

        // add it to set
        current.push(data);
        // update current stack size
        stackSize++;
    }

    public int pop() throws Exception {
        int numOfStacks = setOfStacks.size();
        // if setOfStacks empty, throw error
        if(numOfStacks == 0)
            throw new Exception("Set of stacks empty");

        // pop off item of last stack
        int data = setOfStacks.get(numOfStacks - 1).pop();
        // decrement stackSize
        stackSize--;

        // if stackSize = 0, remove stack from setOfstacks and reset stacksize
        if(stackSize == 0) {
            setOfStacks.remove(numOfStacks - 1);
            stackSize = threshold;
        }

        return data;
    }

    /**
     * Implement popAt function which removes element from specific stack
     */
    // Node class
    class Node {
        Node below;
        Node above;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    // Stack class
    class Stack {
        int size = 0;
        int capacity;
        Node top;
        Node bottom;

        public Stack(int capa) {
            this.capacity = capa;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void push(int data) {
            if(isFull()) return;
            Node node = new Node(data);
            if(top == null)
                bottom = node;

            top = node;
            join(node, top);
            size++;
        }

        public int pop() {
            if(isEmpty()) return Integer.MAX_VALUE;
            Node current = top;
            top = top.below;
            size--;
            return current.data;
        }

        public void join(Node current, Node top) {
            if(current != null) current.below = top;
            if(top != null) top.above = current;
        }

        public int removeBotton() {
            Node current = bottom;
            bottom = bottom.above;
            if(bottom != null) bottom.below = null;
            size--;
            return current.data;
        }
    }

    // SetOfStacks class
    class SetStacks{
        ArrayList<Stack> stacks = new ArrayList<>();
        int capacity;

        public SetStacks(int capa) {
            this.capacity = capa;
        }

        public Stack getLastStack() {
            int size = stacks.size();
            if(size == 0) return null;
            return stacks.get(size - 1);
        }

        public void push(int data) {
            Stack currentStack = getLastStack();
            if(currentStack == null || currentStack.isFull()) {
                Stack newStack = new Stack(capacity);
                newStack.push(data);
                stacks.add(newStack);
            } else {
                currentStack.push(data);
            }
        }

        public int pop() throws Exception {
            Stack currentStack = getLastStack();
            if(currentStack == null)
                throw new Exception("Stack is empty");

            int item = currentStack.pop();
            if(currentStack.isEmpty())
                stacks.remove(stacks.size() - 1);
            return item;
        }

        public int popAt(int index) throws Exception {
            return shift(index, true);
        }

        public int shift(int stackNo, boolean fromTop) throws Exception {
            Stack currentStack = stacks.get(stackNo);
            if(currentStack.isEmpty())
                throw new Exception("Stack is empty!");
            int removedItem;
            if(fromTop)
                removedItem = currentStack.pop();
            else
                removedItem = currentStack.removeBotton();

            if(currentStack.isEmpty())
                stacks.remove(stackNo);
            else if(currentStack.size > stackNo + 1) {
                int swap = shift(stackNo + 1, false);
                currentStack.push(swap);
            }

            return removedItem;
        }
    }
}
