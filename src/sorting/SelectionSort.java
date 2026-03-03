package sorting;

public final class SelectionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int mn = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mn]) {
                    mn = j;
                }
            }
            swap(arr, i, mn);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
