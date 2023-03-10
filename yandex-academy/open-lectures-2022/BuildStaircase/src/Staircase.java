public class Staircase {

    public static int countSteps(int blocks) {
        int nowInStep = 1;
        int steps = 0;

        while (blocks >= nowInStep) {
            blocks -= nowInStep;
            steps += 1;
            nowInStep += 1;
        }
        return steps;
    }

    public static void printStaircase(int maxStairBlocks) {
        int nowInStep = 1;
        int blocks = 0;

        for (int i = 1; i <= maxStairBlocks; i++) {
            System.out.print("\u25A1 ");
            blocks += 1;
            if (blocks == nowInStep) {
                System.out.print("\n");
                nowInStep += 1;
                blocks = 0;
            }
        }
    }
}