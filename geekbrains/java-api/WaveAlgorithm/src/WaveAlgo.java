public class WaveAlgo {

    /**
     * Take step as argument. Scan array with for loop and if
     * find number equal to number of step check surrounding cells:
     * - do they contain numbers
     * - are they the boundaries of the maze
     * Save step + 1 value in such cells
     */
    private static void makeStep(int[][] maze, int[][] mazeTmp, int step) {

        int lenRow = mazeTmp.length - 1;
        int lenCol = mazeTmp[0].length - 1;

        for (int i = 1; i < lenRow; i++) {
            for (int j = 1; j < lenCol; j++) {
                if (mazeTmp[i][j] == step) {
                    if (mazeTmp[i - 1][j] == 0 && maze[i - 1][j] == 0) {
                        mazeTmp[i - 1][j] = step + 1;
                    }
                    if (mazeTmp[i][j - 1] == 0 && maze[i][j - 1] == 0) {
                        mazeTmp[i][j - 1] = step + 1;
                    }
                    if (mazeTmp[i + 1][j] == 0 && maze[i + 1][j] == 0) {
                        mazeTmp[i + 1][j] = step + 1;
                    }
                    if (mazeTmp[i][j + 1] == 0 && maze[i][j + 1] == 0) {
                        mazeTmp[i][j + 1] = step + 1;
                    }
                }
            }
        }
    }

    /**
     * Count number of steps
     */
    public static void countSteps(int[][] maze, int[][] mazeTmp) {

        int step = 0;
        int lenRow = mazeTmp.length - 2;
        int lenCol = mazeTmp[0].length - 2;

        for (int i = 1; i <= lenRow; i++) {
            for (int j = 1; j <= lenCol; j++) {
                if (mazeTmp[lenRow][lenCol] == 0) {
                    step += 1;
                    makeStep(maze, mazeTmp, step);
                }
            }
        }
    }

    public static void printArray(int[][] arr) {

        int lenRow = arr.length;
        int lenCol = arr[0].length;

        for (int i = 0; i < lenRow; i++) {
            for(int j = 0; j < lenCol; j++) {
                System.out.print(arr[i][j] + " ");
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
