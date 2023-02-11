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
}
