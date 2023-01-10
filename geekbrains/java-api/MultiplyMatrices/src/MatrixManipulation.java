import java.util.Random;

public class MatrixManipulation {

    public static int[][] create(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        int min = 0;
        int max = 10;
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
        return matrix;
    }

    public static void print(int[][] matrix) {
        int lenRow = matrix.length;
        int lenCol = matrix[0].length;

        for (int i = 0; i < lenRow; i++) {
            for (int j = 0; j < lenCol; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
