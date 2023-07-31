package validation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TimePointsValidator implements TimeValidator {
    private static final String TIME_POINT_REGEX = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";
    private Scanner scanner;
    private int expectedCount;

    public TimePointsValidator(Scanner scanner, int expectedCount) {
        this.scanner = scanner;
        this.expectedCount = expectedCount;
    }

    @Override
    public String[] validateTimePoints() {
        while (true) {
            String input = scanner.nextLine();
            String[] timePoints = input.split("\\s+");

            if (timePoints.length != expectedCount) {
                System.out.print("Invalid input. Please enter exactly " + expectedCount + " time points: ");
                continue;
            }

            boolean allValid = true;

            for (String timePoint : timePoints) {
                if (!Pattern.matches(TIME_POINT_REGEX, timePoint)) {
                    allValid = false;
                    break;
                }
            }

            if (!allValid) {
                System.out.print("Invalid input. Please enter time points in HH:MM format separated by whitespace: ");
            } else {
                return timePoints;
            }
        }
    }
}
