import java.util.Random;

public class ArrayManipulation {

    public static int[][] replaceElem(int[][] arr) {
        int rowsLen = arr.length;
        int columnsLen = arr[0].length;

        for (int i = 0; i < rowsLen; i++) {
            for (int j = 0; j < columnsLen; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    arr[i][j] = (int)Math.pow(arr[i][j], 2);
                } else {
                    arr[i][j] = (int)Math.pow(arr[i][j], 3);
                }
            }
        }
        return arr;
    }

    public static int[][] create(int rowsLen, int columnsLen) {
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

    public static void print(int[][] arr) {
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
