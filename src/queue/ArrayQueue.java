package queue;

public class ArrayQueue<T> {

    private Object[] arr;

    private int head;

    private int size;

    public ArrayQueue(int capacity) {
        this.arr = new Object[capacity];
        this.head = 0;
        this.size = 0;
    }

    public void enqueue(T value) throws FullQueueException {
        if (size == arr.length) {
            throw new FullQueueException();
        }
        int tail = (head + size) % arr.length;
        arr[tail] = value;
        size++;
    }

    public T dequeue() throws EmptyQueueException {
        if (size == 0) {
            throw new EmptyQueueException();
        }
        T value = (T) arr[head];
        arr[head] = null;
        head = (head + 1) % arr.length;
        size--;
        return value;
    }
}
