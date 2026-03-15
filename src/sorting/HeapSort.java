package sorting;

import heap.ArrayMinHeap;

public final class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        ArrayMinHeap minHeap = new ArrayMinHeap(arr);

        int i = 0;
        while (!minHeap.isEmpty()) {
            arr[i++] = minHeap.poll();
        }
    }

    public static void inPlaceHeapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxBubbleDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call maxBubbleDown on the reduced heap
            maxBubbleDown(arr, i, 0);
        }
    }

    private static void maxBubbleDown(int[] arr, int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && arr[left] > arr[largest]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;

        if (largest != index) {
            int swap = arr[index];
            arr[index] = arr[largest];
            arr[largest] = swap;
            maxBubbleDown(arr, size, largest);
        }
    }
}
