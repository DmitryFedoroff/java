public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;

        for (int day : days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;

        for (int day : days) {
            maxSteps = Math.max(maxSteps, day);
        }
        return maxSteps;
    }
}