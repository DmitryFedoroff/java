import java.util.Random;

public class MatrixManipulation {

    public static void sumMainDiag(int[][] matr) {
        int sum = 0;
        int minLen = Math.min(matr.length, matr[0].length);

        for (int i = 0; i < minLen; i++) {
            sum += matr[i][i];
        }
        System.out.print("Sum of elements on matrix main diagonal: " + sum);
    }

    public static int[][] create(int rows, int columns) {
        int[][] matr = new int[rows][columns];
        int min = 0;
        int max = 10;
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matr[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
        return matr;
    }

    public static void print(int[][] matr) {
        int lenRow = matr.length;
        int lenCol = matr[0].length;

        for (int i = 0; i < lenRow; i++) {
            for (int j = 0; j < lenCol; j++) {
                System.out.print(matr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
