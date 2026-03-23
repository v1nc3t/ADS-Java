package sorting;

import org.junit.jupiter.api.*;

class SortingTest {

    @Test
    void testBucketSortFloats() {
        float[] arrF = new float[] { 0.3f, 0.8f, 0.1f, 0.5f, 0.6f, 0.2f, 0.4f, 0.9f, 0.7f };
        float[] expectedF = new float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f };
        BucketSort.bucketSort(arrF);
        Assertions.assertArrayEquals(expectedF, arrF);
    }

    @Nested
    class IntegerSortingTests {
        private int[] arr;

        private int[] expected;

        @BeforeEach
        void setUp() {
            arr = new int[]{3, 10, 8, 1, 5, 6, 2, 4, 9, 7};
            expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        }

        @AfterEach
        void tearDown() {
            Assertions.assertArrayEquals(expected, arr);
        }

        @Test
        void testBogoSort() {
            BogoSort.bogoSort(arr);
        }

        @Test
        void testBubbleSort() {
            BubbleSort.bubbleSort(arr);
        }

        @Test
        void testInsertionSort() {
            InsertionSort.insertionSort(arr);
        }

        @Test
        void testSelectionSort() {
            SelectionSort.selectionSort(arr);
        }

        @Test
        void testHeapSort() {
            HeapSort.heapSort(arr);
        }

        @Test
        void testInPlaceHeapSort() {
            HeapSort.inPlaceHeapSort(arr);
        }

        @Test
        void testMergeSort() {
            MergeSort.mergeSort(arr, 0, arr.length - 1);
        }

        @Test
        void testQuickSort() {
            QuickSort.quickSort(arr, 0,  arr.length - 1);
        }

        @Test
        void testQuickSortInPlace() {
            QuickSort.quickSortInPlace(arr, 0,  arr.length - 1);
        }

        @Test
        void testBucketSortIntegers() {
            BucketSort.bucketSortIntegers(arr);
        }
        @Test
        void testRadixSort() {
            RadixSort.radixSort(arr);
        }

    }

}
