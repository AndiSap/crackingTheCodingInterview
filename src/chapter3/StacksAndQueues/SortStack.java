package chapter3.StacksAndQueues;

import java.util.Stack;

public class SortStack {

    /**
     * Sort a stack such that the smallest items are on top.
     * Only 1 additional stack is allowed
     *
     * Idea: pop current top of original stack
     *       pop all items that are > than that element from temp stack & insert current item
     *       all these popped items will be pushed onto original stack
     *       repeat until original stack empty -> temp stack is now sorted such that biggest is on top
     */
    public void sort(Stack<Integer> stack) {
        Stack<Integer> reversed = new Stack<>();

        while(!stack.isEmpty()) {
            int element = stack.pop();
            while(!reversed.isEmpty() && reversed.peek() > element) {
                stack.push(reversed.pop());
            }
            reversed.push(element);
        }

        while(!reversed.isEmpty())
            stack.push(reversed.pop());
    }
}
