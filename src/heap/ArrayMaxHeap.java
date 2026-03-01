package heap;

public class ArrayMaxHeap<T> {

    private int[] keys;

    private T[] values;

    private int size;

    public ArrayMaxHeap(int capacity) {
        this.keys = new int[capacity];
        this.values = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void add(int key, T value) {
        if (size == keys.length) {
            int newCapacity = keys.length * 2;
            int[] newKeys = new int[newCapacity];
            T[] newValues = (T[]) new Object[newCapacity];

            System.arraycopy(keys, 0, newKeys, 0, size);
            System.arraycopy(values, 0, newValues, 0, size);

            keys = newKeys;
            values = newValues;
        }
        keys[size] = key;
        values[size] = value;
        bubbleUp(size);
        size++;
    }

    private void bubbleUp(int k) {
        while (k > 0) {
            int i = (k - 1) / 2;
            if (keys[k] > keys[i]) {
                swap(k, i);
                k = i;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int tempKey = keys[i];
        keys[i] = keys[j];
        keys[j] = tempKey;

        T tempValue = values[i];
        values[i] = values[j];
        values[j] = tempValue;
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T result = values[0];

        keys[0] = keys[size - 1];
        values[0] = values[size - 1];

        values[size - 1] = null;
        size--;

        if (size > 0) {
            bubbleDown();
        }

        return result;
    }

    private void bubbleDown() {
        int k = 0;
        while (true) {
            int left =  2 * k + 1;
            int right = 2 * k + 2;
            int largest = k;

            if (left < size && keys[left] > keys[largest]) {
                largest = left;
            }
            if (right < size && keys[right] > keys[largest]) {
                largest = right;
            }

            if (largest != k) {
                swap(k, largest);
                k = largest;
            } else {
                break;
            }
        }
    }

}
