public class QuickSort {

    static int getPivotIndex(int[] arr, int minIdx, int maxIdx) {
        int pivotIdx = minIdx - 1;

        for (int i = minIdx; i < maxIdx; i++) {
            if (arr[i] < arr[maxIdx]) {
                pivotIdx++;
                swap(arr, i, pivotIdx);
            }
        }
        pivotIdx++;
        swap(arr, pivotIdx, maxIdx);
        return pivotIdx;
    }

    static void swap(int[] array, int leftValue, int rightValue) {
        int temp = array[leftValue];
        array[leftValue] = array[rightValue];
        array[rightValue] = temp;
    }
}
