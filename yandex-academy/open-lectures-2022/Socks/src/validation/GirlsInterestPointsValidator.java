package validation;

import java.util.Scanner;

public class GirlsInterestPointsValidator implements GirlsInterestPointsValidatorInterface {
    private Scanner scanner;
    private int expectedCount;

    public GirlsInterestPointsValidator(Scanner scanner, int expectedCount) {
        this.scanner = scanner;
        this.expectedCount = expectedCount;
    }

    @Override
    public int[] validateInterestPoints() {
        int[] points = new int[expectedCount];

        for (int i = 0; i < expectedCount; i++) {
            while (true) {
                System.out.print("Enter point of girl's interest #" + (i + 1) + ": ");
                String input = scanner.nextLine();
                try {
                    points[i] = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter valid integer.");
                }
            }
        }
        return points;
    }
}
