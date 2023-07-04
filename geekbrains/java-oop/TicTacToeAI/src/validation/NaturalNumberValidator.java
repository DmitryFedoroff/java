package validation;

import java.util.Scanner;

public class NaturalNumberValidator implements InputValidator {
    private static final String NATURAL_NUMBER_REGEX = "^[1-9]\\d*$";
    private Scanner scanner;

    public NaturalNumberValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int[] validate() {
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches(NATURAL_NUMBER_REGEX)) {
                System.out.print("Invalid input. Please enter natural number: ");
            } else {
                return new int[]{Integer.parseInt(input)};
            }
        }
    }
}
