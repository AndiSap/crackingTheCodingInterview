package chapter3.StacksAndQueues;

public class ThreeInOne {

    /**
     * Single array to implement 3 stacks
     * Fixed size approach: Divide array into 3 equal parts
     */
    class FixedMultiStack {
        int[] values;
        int[] sizes;
        private int numberOfStacks = 3;
        private int stackCapacity;

        public FixedMultiStack(int stackSize) {
            sizes = new int[numberOfStacks];
            values = new int[numberOfStacks * stackSize];
            stackCapacity = stackSize;
        }

        public void push(int stackNumber, int value) throws Exception {
            if(isFull(stackNumber))
                throw new Exception("Stack is full!");

            values[indexOfTop(stackNumber)] = value;
            sizes[stackNumber]++;
        }

        public int pop(int stackNumber) throws Exception {
            if(isEmpty(stackNumber))
                throw new Exception("Stack is empty!");

            int element = values[indexOfTop(stackNumber)];
            values[indexOfTop(stackNumber)] = 0;
            sizes[stackNumber]--;
            return element;
        }

        public int peek(int stackNumber) throws Exception {
            if (isEmpty(stackNumber))
                throw new Exception("Stack is empty!");

            return values[indexOfTop(stackNumber)];
        }

            public boolean isEmpty(int stackNumber) {
            return sizes[stackNumber] == 0;
        }

        public boolean isFull(int stackNumber) {
            return sizes[stackNumber] == stackCapacity;
        }

        public int indexOfTop(int stackNumber) {
            int offset = stackNumber * stackCapacity;
            int sizeIdx = sizes[stackNumber] - 1; // needs index of last element!
            return offset + sizeIdx;
        }
    }

}
