import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[4];
        int len = array.length;
        int min = 100;
        int max = 1000;
        Random rand = new Random();

        for (int i = 0; i < len; i++) {
            array[i] = rand.nextInt(max - min + 1) + min;
        }
        System.out.println("Original array: " + Arrays.toString(array));
    }
}
