package stack;

public class DynamicStack<T> {

    private Object[] elements;
    private int size;
    private int capacity;

    public DynamicStack() {
        this.elements = new Object[capacity];
        this.size = 0;
        this.capacity = 1;
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
        return (T) elements[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;
        T res = (T) elements[size];
        elements[size] = null;

        if (capacity > 1 && size < capacity * 0.25) {
            Object[] newElements = new Object[capacity / 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        return res;
    }

    public void push(T element) {
        if (isFull()) {
            Object[] newElements = new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size] = element;
        size++;
    }
}
