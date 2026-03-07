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
}
