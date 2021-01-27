package chapter3.StacksAndQueues;

import java.util.Stack;

/**
 * Implement queue class which implements a queue using 2 stacks
 * First approach: Toggle inbetween stacks
 * Inefficient -> since it always toggles between stacks
 */
public class QueueUsingStacks<T> {
    Stack<T> stack;
    Stack<T> temp;

    public QueueUsingStacks() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(T item) {
        stack.push(item);
    }

    public T pop() {
        T firstItem = null;
        while(!stack.isEmpty()) {
            firstItem = stack.pop();
            temp.push(firstItem);
        }

        temp.pop(); // do not use item which will be poped
        while(!temp.isEmpty())
            stack.push(temp.pop());

        return firstItem;
    }

    public T peek() {
        T firstItem = null;
        while(!stack.isEmpty()) {
            firstItem = stack.pop();
            temp.push(firstItem);
        }

        while(!temp.isEmpty())
            stack.push(temp.pop());

        return firstItem;
    }
}

/**
 * Second implementation:
 * Only switch elements from main stack if reverse stack is empty
 */
class MyQueueWithStacks<T> {
    Stack<T> stackNewest;
    Stack<T> stackOldest;

    public MyQueueWithStacks() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public void push(T item) {
        stackNewest.push(item);
    }

    public T pop() {
        if(stackOldest.isEmpty())
            shiftStacks();

        return stackOldest.pop();
    }

    public T peek() {
        if(stackOldest.isEmpty())
            shiftStacks();

        return stackOldest.peek();
    }

    public void shiftStacks() {
        while(!stackNewest.isEmpty())
            stackOldest.push(stackNewest.pop());
    }
}
