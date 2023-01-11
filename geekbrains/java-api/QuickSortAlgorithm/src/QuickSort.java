public class QuickSort {

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }

    static void swap(int[] arr, int low, int pivot) {
        int temp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int p = low, j;

        for (j = low + 1; j <= high; j++) {
            if (arr[j] < arr[low]) {
                swap(arr, ++p, j);
            }
        }
        swap(arr, low, p);
        return p;
    }
}
