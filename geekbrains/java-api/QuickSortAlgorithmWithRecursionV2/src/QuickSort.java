public class QuickSort {

    public static void sort(int[] inputArray, int minIdx, int maxIdx) {
        if (minIdx < maxIdx) {

            int pivot = randomizedPartition(inputArray, minIdx, maxIdx);

            sort(inputArray, minIdx, pivot - 1);
            sort(inputArray, pivot + 1, maxIdx);
        }
    }

    static int randomizedPartition(int[] arr, int minIdx, int maxIdx) {
        int randIdx = (int) (Math.random() * (maxIdx - minIdx + 1)) + minIdx;

        swap(arr, randIdx, maxIdx);

        int pivot = arr[maxIdx];
        int i = minIdx - 1;

        for (int j = minIdx; j < maxIdx; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, maxIdx);
        return i + 1;
    }

    static void swap(int[] array, int leftValue, int rightValue) {
        int temp = array[leftValue];
        array[leftValue] = array[rightValue];
        array[rightValue] = temp;
    }
}
