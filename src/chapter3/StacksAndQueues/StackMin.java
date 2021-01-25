package chapter3.StacksAndQueues;

import java.util.Stack;

/**
 * Stack which has min function in O(1)
 */
public class StackMin extends Stack<Integer> {
    Stack<Integer> min;

    public StackMin() {
        min = new Stack<>();
    }

    public void push(int data) {
        super.push(data);
        if(data < min())
            min.push(data);
    }

    public Integer pop() {
        int data = super.pop();
        if(data == min())
            min.pop();

        return data;
    }

    public int min() {
        if(min.isEmpty())
            return Integer.MAX_VALUE;

        return min.peek();
    }

}
