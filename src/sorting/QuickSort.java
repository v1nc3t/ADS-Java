package sorting;

import java.util.Random;

public final class QuickSort {

    public static void quickSortInPlace(int[] arr, int l, int r) {
        if (l >= r) return;
        // randomize
        // random(arr, l, r);

        // choose last element as pivot
        int pivot = arr[r];
        int left = l;
        int right = r - 1;

        while (left <= right) {
            while (left <= right && arr[left] < pivot) left++;
            while (left <= right && arr[right] > pivot) right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        swap(arr, left, r);

        quickSortInPlace(arr, l, left - 1);
        quickSortInPlace(arr, left + 1, r);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if  (l < r) {
            int pivot = partition(arr, l, r);

            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        // randomize
        // random(arr, l, r);
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void random(int[] arr, int l, int r) {
        Random random = new Random();
        int pivot = random.nextInt(r - l + 1) + l;

        swap(arr, pivot, r);
    }
}
