package chapter3.StacksAndQueues;

public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    QueueNode<T> first;
    QueueNode<T> last;

    /**
     * Adds data to the end of the queue
     */
    public void add(T data) {
        QueueNode<T> node = new QueueNode<>(data);
        if(last != null) {
            last.next = node;
        }
        last = node;
        if(first == null)
            first = last;
    }

    /**
     * Removes and returns data at the start of the queue
     */
    public T remove() throws Exception {
        if(first == null)
            throw new Exception("Queue is empty");

        T element = first.data;
        first = first.next;
        if(first == null) // queue is now empty
            last = null;

        return element;
    }

    /**
     * Only returns data at the start of the queue
     */
    public T peek() throws Exception {
        if(first == null)
            throw new Exception("Queue is empty");

        return first.data;
    }

    /**
     * Returns if queue has no elements left
     */
    public boolean isEmpty() {
        return first == null;
    }
}
