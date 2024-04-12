import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int i = scanner.nextInt();

            switch (i) {
                case 1:
                    tracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    tracker.changeStepGoal();
                    break;
                case 3:
                    tracker.printStatistic();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("\nТакой команды нет. Попробуйте снова.");
            }
        }
    }
}
