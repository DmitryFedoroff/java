import java.util.Random;

public class ArrayManipulation {

    public static void bubbleSortRow(int[][] arr) {
        int rowsLen = arr.length;
        int columnsLen = arr[0].length;

        for (int i = 0; i < rowsLen; i++) {
            for (int j = 0; j < columnsLen; j++) {
                for (int k = j + 1; k < columnsLen; k++) {
                    if (arr[i][j] < arr[i][k]) {
                        int temp = arr[i][j];
                        arr[i][j] = arr[i][k];
                        arr[i][k] = temp;
                    }
                }
            }
        }
    }

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

    public static void print(int[][] arr) {
        int rowsLen = arr.length;
        int columnsLen = arr[0].length;

        for (int i = 0; i < rowsLen; i++) {
            for (int j = 0; j < columnsLen; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
