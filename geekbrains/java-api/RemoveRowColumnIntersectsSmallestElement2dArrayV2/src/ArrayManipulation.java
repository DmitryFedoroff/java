import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ArrayManipulation {

    static Map<String, Integer> findArrayMinValues(int[][] arr) {
        Map<String, Integer> minValues = new HashMap<>();
        int minElemRow = 0;
        int minElemCol = 0;
        int minElem = arr[minElemRow][minElemCol];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] < minElem) {
                    minElem = arr[i][j];
                    minValues.put("minValue", minElem);
                    minValues.put("minElemRow", i);
                    minValues.put("minElemCol", j);
                }
            }
        }
        return minValues;
    }

    static void printArrayMinValues(Map<String, Integer> minValues) {
        System.out.println("First smallest element: " + minValues.get("minValue"));
        System.out.println("Row index: " + minValues.get("minElemRow"));
        System.out.println("Column index: " + minValues.get("minElemCol"));
        System.out.println();
    }

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
