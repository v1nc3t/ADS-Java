package sorting;

public final class RadixSort {

    public static void radixSort(int[] arr) {
        int n = arr.length;
        int m = getMax(arr);
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    private static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];

        // count frequency of digits
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // create the prefix sum
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // order based on digit using prefix sum
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }


    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
