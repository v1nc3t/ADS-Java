package array;

public final class ArrayUtils {

    private ArrayUtils() {}

    /**
     * Merges two sorted arrays such that the resulting array has all elements
     * from both arrays and is also sorted. Assumes that the elements in the
     * given arrays are sorted in non-decreasing order. If there are duplicate
     * elements in the input arrays, these should also be present in the
     * resulting array. If both arrays are null the result should be null, or a
     * copy of the non-null array if only one is null.
     * Efficiency requirements: merge the two arrays in a single pass.
     *
     * @param arr1 first sorted array to be merged
     * @param arr2 second sorted array to be merged
     * @return sorted array containing all elements from both arrays
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return null;
        }
        if (arr1 == null) {
            return arr2;
        }
        if (arr2 == null) {
            return arr1;
        }
        int size1 = arr1.length, size2 = arr2.length;
        int[] res = new int[size1 + size2];
        int i = 0, j = 0;
        int size = 0;
        while (i < size1 && j < size2) {
            if (arr1[i] < arr2[j]) {
                res[size] = arr1[i];
                i++;
            } else {
                res[size] = arr2[j];
                j++;
            }
            size++;
        }
        while (i < size1) {
            res[size++] = arr1[i++];
        }
        while (j < size2) {
            res[size++] = arr2[j++];
        }
        return res;
    }

    /**
     * Takes the array and the last occurring element x,
     * shifting the rest of the elements left. I.e.
     * [1, 4, 7, 9], with x=7 would result in:
     * [1, 4, 9].
     *
     * @param x the entry to remove from the array
     * @param arr to remove an entry from
     * @return the updated array, without the last occurrence of x
     */
    public static int[] removeLastOccurrence(int x, int[] arr) {
        int size = arr.length;
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == x) {
                int[] newArr = new int[size - 1];
                int c = 0;
                for (int j = 0; j < size; j++) {
                    if (j != i) {
                        newArr[c++] = arr[j];
                    }
                }
                return newArr;
            }
        }
        return arr;
    }

    /**
     * Clones the given two-dimensional array (makes a deep copy).
     *
     * @param a array to copy.
     * @return a deep copy of the array.
     */
    static double[][] clone(double[][] a) {
        double[][] clone = new double[a.length][];
        for (int i = 0; i < a.length; i++) {
            clone[i] = new double[a[i].length];
            for (int j = 0; j < a[i].length; j++) {
                clone[i][j] = a[i][j];
            }
        }
        return clone;
    }
}
