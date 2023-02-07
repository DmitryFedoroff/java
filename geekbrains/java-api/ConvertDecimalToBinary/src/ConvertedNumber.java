public class ConvertedNumber {

    public static int findArrSize(int num) {
        int temp = num;
        int count = 0;

        while (temp != 0) {
            temp = temp / 2;
            count++;
        }
        return count;
    }

    public static int[] convertToBinary(int[] arr, int num) {
        int i = 0;

        while (num != 0) {
            arr[i] = num % 2;
            num = num / 2;
            i++;
        }
        return arr;
    }
}
