package chapter3.StacksAndQueues;

public class MyStack<T> {
    private static class StackNode<T> {
        private StackNode<T> next;
        private T data;

        public StackNode(T data) {
            this.data = data;
        }
    }

    StackNode<T> top;

    /**
     * Adds new element to top of stack
     */
    public void push(T item) {
        StackNode<T> node = new StackNode<>(item);
        node.next = top;
        top = node;
    }

    /**
     * Removes and return element on top of the stack
     */
    public T pop() throws Exception {
        if(top == null)
            throw new Exception("Stack is empty");
        T element = top.data;
        top = top.next;
        return element;
    }

    /**
     * Only returns element on top of the stack
     */
    public T peek() throws Exception {
        if(top == null)
            throw new Exception("Stack is empty");

        return top.data;
    }

    /**
     * Returns if stack has no elements left
     */
    public boolean isEmpty() {
        return top == null;
    }
}
