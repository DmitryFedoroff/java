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

    void printStatistic() {
        System.out.println("\nВведите номер месяца для вывода статистики:");
        int month = scanner.nextInt() - 1;

        if (month < 0 || month > 11) {
            System.out.println("\nНеверный номер месяца.");
            return;
        }

        MonthData monthData = monthToData[month];
        monthData.printDaysAndStepsFromMonth();

        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("\nОбщее количество шагов за месяц: " + sumSteps);

        int maxSteps = monthData.maxSteps();
        System.out.println("Максимальное количество шагов в месяце: " + maxSteps);

        int avgSteps = sumSteps / 30;
        System.out.println("Среднее количество шагов: " + avgSteps);

        int distance = Converter.convertToKm(sumSteps);
        System.out.println("Пройденная дистанция (в километрах): " + distance);

        int calories = Converter.convertStepsToKilocalories(sumSteps);
        System.out.println("Количество сожжённых килокалорий: " + calories);

        int bestSeries = monthData.bestSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия: " + bestSeries + " дней подряд.");
    }
}
