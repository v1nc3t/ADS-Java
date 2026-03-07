package sorting;

import java.util.ArrayList;
import java.util.List;

public final class BucketSort {

    public static void bucketSort(float[] arr) {
        int n = arr.length;

        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (float v : arr) {
            int bI = (int) (n * v);
            buckets[bI].add(v);
        }

        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[k] = buckets[i].get(j);
                k++;
            }
        }
    }

    private static void insertionSort(List<Float> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            Float temp = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > temp) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, temp);
        }
    }
}
