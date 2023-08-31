package validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableSocksPointsValidator implements InputValidator {

    public static final int EXPECTED_INPUT_SIZE = 3;
    private static final int TOO_MANY_INPUTS = 1;
    private static final int TOO_FEW_INPUTS = -1;
    private static final String NATURAL_NUMBER_REGEX = "^[1-9]\\d*$";
    private Scanner scanner;

    public TableSocksPointsValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<Integer> validate() {
        while (true) {
            String input = scanner.nextLine();
            String[] inputNumbers = input.split("\\s+");
            List<Integer> inputIntegers = new ArrayList<>();
            boolean allValid = true;

            for (String number : inputNumbers) {
                if (!number.matches(NATURAL_NUMBER_REGEX)) {
                    allValid = false;
                    break;
                }
                inputIntegers.add(Integer.parseInt(number));
            }

            if (!allValid) {
                System.out.println("Input values are not natural numbers separated by whitespace.");
                System.out.print("Please try again: ");
                continue;
            }

            if (inputNumbers.length - EXPECTED_INPUT_SIZE == TOO_MANY_INPUTS) {
                System.out.println("Too many input values. Please enter exactly " + EXPECTED_INPUT_SIZE + " natural numbers separated by whitespace.");
                System.out.print("Please try again: ");
                continue;
            }

            if (inputNumbers.length - EXPECTED_INPUT_SIZE == TOO_FEW_INPUTS) {
                System.out.println("Too few input values. Please enter exactly " + EXPECTED_INPUT_SIZE + " natural numbers separated by whitespace.");
                System.out.print("Please try again: ");
                continue;
            }
            return inputIntegers;
        }
    }
}
