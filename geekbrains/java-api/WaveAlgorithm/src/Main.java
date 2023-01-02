public class Main {

    public static void main(String[] args) {

        int[][] maze = new int[][] {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        /* Create temp matrix for necessary calculations */
        int start = 1;
        int[][] mazeTmp = new int[maze.length][maze[0].length];
        mazeTmp[start][start] = 1;

        System.out.println("Maze:");
        WaveAlgo.printArray(maze);
        WaveAlgo.countSteps(maze, mazeTmp);
    }
}
