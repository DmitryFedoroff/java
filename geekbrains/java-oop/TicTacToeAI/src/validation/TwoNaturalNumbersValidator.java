package validation;

import java.util.Scanner;

public class TwoNaturalNumbersValidator implements InputValidator {
    private static final String TWO_NATURAL_NUMBERS_REGEX = "^[1-9]\\d*\\s[1-9]\\d*$";
    private Scanner scanner;

    public TwoNaturalNumbersValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int validateNumber() {
        throw new UnsupportedOperationException("Method validateNumber() is not supported in this class.");
    }

    @Override
    public int[] validateNumbers() {
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches(TWO_NATURAL_NUMBERS_REGEX)) {
                System.out.print("Invalid input. Please enter two natural numbers separated by a space: ");
            } else {
                String[] numbers = input.split("\\s");
                return new int[]{Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])};
            }
        }
    }

    @Override
    public String validateSymbol() {
        throw new UnsupportedOperationException("Method validateSymbol() is not supported in this class.");
    }
}
