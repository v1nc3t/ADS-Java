package sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static void bucketSortIntegers(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        Queue<Integer>[] buckets = fillBuckets(arr);
        readBuckets(buckets, arr);
    }

    private static Queue<Integer>[] fillBuckets(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new Queue[0];
        }
        int vmin = arr[0], vmax = arr[0];
        for (int v : arr) {
            if (v < vmin) {
                vmin = v;
            }
            if (v > vmax) {
                vmax = v;
            }
        }
        Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];
        for (int v : arr) {
            int i = v - vmin;
            if (buckets[i] == null) {
                buckets[i] = new LinkedList<>();
            }
            buckets[i].add(v);
        }
        return buckets;
    }

    private static void readBuckets(Queue<Integer>[] buckets, int[] arr) {
        int i = 0;
        for (Queue<Integer> bucket : buckets) {
            if (bucket != null) {
                while (!bucket.isEmpty()) {
                    arr[i++] = bucket.poll();
                }
            }
        }
    }
}
