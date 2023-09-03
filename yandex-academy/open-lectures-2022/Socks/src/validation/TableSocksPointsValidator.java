package validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableSocksPointsValidator implements InputValidator {

    public static final int EXPECTED_INPUT_SIZE = 3;
    private static final String NATURAL_NUMBER_REGEX = "^[1-9]\\d*$";
    private Scanner scanner;

    public TableSocksPointsValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<Integer> validate() {
        List<Integer> inputIntegers = new ArrayList<>();

        while (inputIntegers.size() != EXPECTED_INPUT_SIZE) {
            promptUserForInput();

            String[] inputNumbers = scanner.nextLine().split("\\s+");

            if (isInputSizeIncorrect(inputNumbers.length)) {
                notifyIncorrectInputSize();
                continue;
            }

            inputIntegers = convertStringsToIntegers(inputNumbers);

            if (inputIntegers.size() != EXPECTED_INPUT_SIZE) {
                notifyInvalidNumbers();
                inputIntegers.clear();
            }
        }

        return inputIntegers;
    }

    private void promptUserForInput() {
        System.out.print("Enter " + EXPECTED_INPUT_SIZE + " natural numbers separated by whitespace: ");
    }

    private boolean isInputSizeIncorrect(int size) {
        return size != EXPECTED_INPUT_SIZE;
    }

    private void notifyIncorrectInputSize() {
        System.out.println("Incorrect number of values. Please enter exactly " + EXPECTED_INPUT_SIZE + " natural numbers.");
    }

    private List<Integer> convertStringsToIntegers(String[] numbers) {
        List<Integer> integers = new ArrayList<>();
        for (String number : numbers) {
            if (number.matches(NATURAL_NUMBER_REGEX)) {
                integers.add(Integer.parseInt(number));
            }
        }
        return integers;
    }

    private void notifyInvalidNumbers() {
        System.out.println("Input values are not natural numbers.");
    }
}
