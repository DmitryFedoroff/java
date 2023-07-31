package validation;

import java.util.Scanner;

public class TrainCountValidator implements NumberValidator {
    private static final String TRAIN_COUNT_REGEX = "^[1-9]\\d*$";
    private Scanner scanner;

    public TrainCountValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int validateNumber() {
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches(TRAIN_COUNT_REGEX)) {
                System.out.print("Invalid input. Please enter natural number for train count: ");
            } else {
                return Integer.parseInt(input);
            }
        }
    }
}
