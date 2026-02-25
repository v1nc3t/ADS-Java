package stack;

public class Stack<T> {

    private Object[] elements;
    private int size;
    private int capacity;

    public Stack(int capacity) {
        this.elements = new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        //noinspection unchecked
        return (T) elements[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;
        //noinspection unchecked
        T res = (T) elements[size];
        elements[size] = null;
        return res;
    }

    public void push(T element) {
        if (isFull()) {
            throw new FullStackException();
        }
        elements[size] = element;
        size++;
    }}
