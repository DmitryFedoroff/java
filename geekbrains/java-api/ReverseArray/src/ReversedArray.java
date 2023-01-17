public class ReversedArray {

    public static void reverse(int[] arr) {
        int temp;
        int len = arr.length;
    
        for (int i = 0; i < len / 2; i++) {
            temp = arr[i];
            arr[i] = arr[len - 1 - i];
            arr[len - 1 - i] = temp;
        }
    }
}
