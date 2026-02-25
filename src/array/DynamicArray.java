package array;

public class DynamicArray<T> {

    private Object[] arr;
    private int size;

    public DynamicArray() {
        this.arr = new Object[1];
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

    public void add(T value) {
        if (size >= arr.length) {
            increaseCapacity();
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

    private void increaseCapacity() {
        Object[] newArr = new Object[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
