package validation;

import java.util.Scanner;

public class FilesAndDirectoriesCountValidator implements TotalCountValidator {
    private static final String COUNT_REGEX = "^[1-9][0-9]{0,2}$";
    private Scanner scanner;

    public FilesAndDirectoriesCountValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int validateTotalCount() {
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches(COUNT_REGEX) || Integer.parseInt(input) > 100) {
                System.out.print("Invalid input. Please enter positive integer between 1 and 100 for total number of files and directories: ");
            } else {
                return Integer.parseInt(input);
            }
        }
    }
}
