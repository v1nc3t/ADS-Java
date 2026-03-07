package sorting;

import java.util.Arrays;

public final class Inversions {

    public static int countInversions(int[] arr){
        int n = arr.length;
        if (n < 2) {
            return 0;
        }
        int m = n / 2;
        int[] left = Arrays.copyOfRange(arr, 0, m);
        int[] right = Arrays.copyOfRange(arr, m, n);

        return countInversions(left) + countInversions(right) + merge(arr, left, right);
    }

    private static int merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0, swaps = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += left.length - i;
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return swaps;
    }
}
