import java.util.Random;

public class MatrixManipulation {

    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int rowA = matrixA.length;
        int columnA = matrixA[0].length;
        int columnB = matrixB[0].length;
        int[][] matrixC = new int[rowA][columnB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnB; j++) {
                int temp = 0;
                for (int k = 0; k < columnA; k++) {
                    temp += matrixA[i][k] * matrixB[k][j];
                }
                matrixC[i][j] = temp;
            }
        }
        return matrixC;
    }

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
