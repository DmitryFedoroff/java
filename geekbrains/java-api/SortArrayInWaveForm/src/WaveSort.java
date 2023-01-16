public class WaveSort {

    public static void sort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i+= 2) {
            if (i > 0 && arr[i - 1] > arr[i]) {
                swap(arr, i - 1, i);
            }
            if (i < len - 1 && arr[i] < arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
