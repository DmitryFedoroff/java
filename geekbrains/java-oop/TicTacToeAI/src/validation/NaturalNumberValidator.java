package validation;

import java.util.Scanner;

public class NaturalNumberValidator implements InputValidator {
    private static final String NATURAL_NUMBER_REGEX = "^[1-9]\\d*$";
    private Scanner scanner;

    public NaturalNumberValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int validateNumber() {
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches(NATURAL_NUMBER_REGEX)) {
                System.out.print("Invalid input. Please enter a natural number: ");
            } else {
                return Integer.parseInt(input);
            }
        }
    }

    @Override
    public int[] validateNumbers() {
        throw new UnsupportedOperationException("Method validateNumbers() is not supported in this class.");
    }

    @Override
    public String validateSymbol() {
        throw new UnsupportedOperationException("Method validateSymbol() is not supported in this class.");
    }
}
