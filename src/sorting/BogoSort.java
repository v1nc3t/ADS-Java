package sorting;

import java.util.Random;

public final class BogoSort {

    public static void bogoSort(int[] arr) {
        while(!sorted(arr)) {
            shuffle(arr);
        }
    }

    private static boolean sorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }


    private static void shuffle(int[] arr) {
        int n = arr.length;
        Random rand = new Random();
        for (int i = n - 1; i >= 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
