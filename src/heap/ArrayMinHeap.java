package heap;

public class ArrayMinHeap {

    private int[] values;

    private int size;

    public ArrayMinHeap(int capacity) {
        values = new int[capacity];
        size = 0;
    }

    public ArrayMinHeap(int[] arr) {
        this.values = arr;
        size = arr.length;
        System.arraycopy(arr, 0, values, 0, size);
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        if (size == values.length) {
            int newCapacity = size * 2;
            int[] temp = new int[newCapacity];
            System.arraycopy(values, 0, temp, 0, size);
            values = temp;
        }
        values[size] = value;
        bubbleUp(size);
        size++;
    }

    private void bubbleUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && values[parentIndex] > values[index]) {
            swap(parentIndex, index);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public int poll() {
        if (size == 0) {
            return -1;
        }
        int result = values[0];
        values[0] = values[size - 1];
        values[size - 1] = 0;
        size--;

        bubbleDown(0);

        return result;
    }


    private void bubbleDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < size && values[leftChild] < values[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < size && values[rightChild] < values[smallest]) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(smallest, index);
            bubbleDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}
