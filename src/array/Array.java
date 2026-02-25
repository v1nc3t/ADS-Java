package array;

import java.util.EmptyStackException;

public class Array {

    private int[] arr;
    private int size;

    public Array(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    public void add(int value) throws FullArrayException {
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
        arr[size] = 0;
    }
}

