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
}
