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

    public static void printBinaryNum(int[] arr, int num) {
        arr = convertToBinary(arr, num);
        int len = arr.length;

        for (int j = len - 1; j >= 0; j--) {
            System.out.print(arr[j]);
        }
    }
}
