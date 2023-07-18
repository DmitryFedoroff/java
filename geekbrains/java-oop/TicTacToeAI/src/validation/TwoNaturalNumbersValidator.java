package validation;

import java.util.Scanner;

public class TwoNaturalNumbersValidator implements TwoNumbersValidator {
    private static final String TWO_NATURAL_NUMBERS_REGEX = "^[1-9]\\d*\\s[1-9]\\d*$";
    private Scanner scanner;

    public TwoNaturalNumbersValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int[] validateNumbers() {
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches(TWO_NATURAL_NUMBERS_REGEX)) {
                System.out.print("Invalid input. Please enter two natural numbers separated by space: ");
            } else {
                String[] numbers = input.split("\\s");
                return new int[]{Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])};
            }
        }
    }
}
