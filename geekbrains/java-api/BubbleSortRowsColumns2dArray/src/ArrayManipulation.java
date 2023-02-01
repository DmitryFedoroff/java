import java.util.Random;

public class ArrayManipulation {

    public static int[][] create(int rowsLen, int columnsLen) {
        int[][] arr = new int[rowsLen][columnsLen];
        int min = 0;
        int max = 9;
        Random rand = new Random();

        for (int i = 0; i < rowsLen; i++) {
            for (int j = 0; j < columnsLen; j++) {
                arr[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
        return arr;
    }
}
