package array;

import java.util.EmptyStackException;

public class Array<T> {

    private Object[] arr;
    private int size;

    public Array(int capacity) {
        this.arr = new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //noinspection unchecked
        return (T) arr[index];
    }

    public void add(T value) throws FullArrayException {
        if (size >= arr.length) {
            throw new FullArrayException();
        }
        arr[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        arr[size] = null;
    }
}

