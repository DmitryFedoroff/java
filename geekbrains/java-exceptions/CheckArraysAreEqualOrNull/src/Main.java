import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] firstArray = fillArray(10);
        int[] secondArray = fillArray(9);
    }

    public static int[] fillArray(int len) {

        int[] array = new int[len];
        Random rand = new Random();

        for (int i = 0; i < len; i++) {
            array[i] = rand.nextInt(1, 10);
        }
        return array;
    }
}