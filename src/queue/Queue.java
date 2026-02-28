package queue;

import java.util.LinkedList;

public class Queue<T> {

    private LinkedList<T> list = new LinkedList<>();

    public Queue() {
        this.list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(T t) {
        list.addLast(t);
    }

    public T dequeue() throws EmptyQueueException {
        if (list.isEmpty()) {
            throw new EmptyQueueException();
        }
        return list.removeFirst();
    }
}
