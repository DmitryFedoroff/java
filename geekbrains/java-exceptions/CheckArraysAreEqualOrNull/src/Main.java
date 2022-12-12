import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] firstArray = fillArray(10);
        int[] secondArray = fillArray(9);
    }

    public static int[] diffArrays(int[] firstArr, int[] secondArr) {

        if (firstArr == null || secondArr == null) {
            throw new RuntimeException("One of incoming arrays is null.");
        }

        if (firstArr.length != secondArr.length) {
            throw new RuntimeException("Arrays have different lengths.");
        }

        int[] array = new int[firstArr.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = firstArr[i] - secondArr[i];
        }
        return array;
    }

    public static int[] fillArray(int len) {

        int[] array = new int[len];
        Random rand = new Random();

        for (int i = 0; i < len; i++) {
            array[i] = rand.nextInt(1, 10);
        }
        return array;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
