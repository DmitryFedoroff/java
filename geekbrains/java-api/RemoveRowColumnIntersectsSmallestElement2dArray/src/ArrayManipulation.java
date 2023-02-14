import java.util.Random;

public class ArrayManipulation {

    public static int[][] createArr(int rowsLen, int columnsLen) {
        int[][] arr = new int[rowsLen][columnsLen];
        int min = 0;
        int max = 10;
        Random rand = new Random();

        for (int i = 0; i < rowsLen; i++) {
            for (int j = 0; j < columnsLen; j++) {
                arr[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
        return arr;
    }

    public static void printArr(int[][] arr) {
        int rowsLen = arr.length;
        int columnsLen = arr[0].length;

        for (int i = 0; i < rowsLen; i++) {
            for (int j = 0; j < columnsLen; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
