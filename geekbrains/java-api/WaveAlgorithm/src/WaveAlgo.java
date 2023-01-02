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

    /**
     * Find the shortest path's length in maze. Define exit point with finish variable.
     * Look for neighboring element with value of finish - 1, go to this cell, decrease finish by 1.
     * Repeat previous step until reach starting point, namely finish = 1.
     * Output to console coordinates of each step from starting point to exit point.
     */
    public static String findShortWay(int[][] mazeTmp) {

        int i = mazeTmp.length - 2;
        int j = mazeTmp.length - 2;
        int finish = mazeTmp[i][j];
        String path = ("(" + i + ", " + j + ") " + "Exit" + "\n");

        while (finish > 1) {
            if (mazeTmp[i - 1][j] == finish - 1) {
                i = i - 1;
                path += ("(" + i + ", " + j + ")" + "\t" + "Down" + "\n");
                finish -= 1;
            } else if (mazeTmp[i][j - 1] == finish - 1) {
                j = j - 1;
                path += ("(" + i + ", " + j + ")" + "\t" + "Right" + "\n");
                finish -= 1;
            } else if (mazeTmp[i + 1][j] == finish - 1) {
                i = i + 1;
                path += ("(" + i + ", " + j + ")" + "\t" + "Up" + "\n");
                finish -= 1;
            } else if (mazeTmp[i][j + 1] == finish - 1) {
                j = j + 1;
                path += ("(" + i + ", " + j + ")" + "\t" + "Left" + "\n");
                finish -= 1;
            }
        }
        return path;
    }

    public static void printPath(int[][] mazeTmp) {

        String[] split = findShortWay(mazeTmp).split("\n");

        for (int i = split.length - 1; i >= 0; i--) {
            System.out.println(split[i] + " ");
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
