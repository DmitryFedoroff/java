public class RotatedArray {

    public static int[] rotate(int[] arr, int k) {
        int len = arr.length;

        if (k > len) {
            k = k % len;
        }

        int[] result = new int[len];

        for (int i = 0; i < k; i++) {
            result[i] = arr[len - k + i];
        }

        int index = 0;

        for (int i = k; i < len; i++) {
            result[i] = arr[index++];
        }
        return result;
    }
}
