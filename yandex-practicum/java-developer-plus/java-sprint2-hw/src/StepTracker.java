import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000; // Цель по умолчанию

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("\nВведите номер месяца:");
        int month = scanner.nextInt() - 1;

        if (month < 0 || month > 11) {
            System.out.println("\nНеверный номер месяца.");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно):");
        int day = scanner.nextInt() - 1;

        if (day < 0 || day > 29) {
            System.out.println("\nНеверный день.");
            return;
        }

        System.out.println("Введите количество шагов:");
        int steps = scanner.nextInt();

        if (steps < 0) {
            System.out.println("\nКоличество шагов не может быть отрицательным.");
            return;
        }

        monthToData[month].days[day] = steps;
        System.out.println("\nКоличество шагов сохранено.");
    }

    void changeStepGoal() {
        System.out.println("\nВведите новую цель по шагам:");
        int newGoal = scanner.nextInt();

        if (newGoal > 0) {
            goalByStepsPerDay = newGoal;
            System.out.println("\nНовая цель установлена.");
        } else {
            System.out.println("\nЦель должна быть больше 0.");
        }
    }
}
