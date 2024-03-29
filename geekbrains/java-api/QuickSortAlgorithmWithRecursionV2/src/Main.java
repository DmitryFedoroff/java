import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10];
        int len = array.length;
        int min = -10;
        int max = 10;
        Random rand = new Random();

        for (int i = 0; i < len; i++) {
            array[i] = rand.nextInt(max - min + 1) + min;
        }
        System.out.println("Original array: " + Arrays.toString(array));
        QuickSort.sort(array, 0, len - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
