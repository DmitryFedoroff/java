package validation;

import java.util.Scanner;

public class TotalFilesAndDirectoriesValidator implements FileNameValidator {
    private static final String FILE_NAME_REGEX = "^[^\\\\/:*?\"<>|]+$";
    private Scanner scanner;

    public TotalFilesAndDirectoriesValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String validateFileName() {
        while (true) {
            String fileName = scanner.nextLine().trim();
            if (fileName.matches(FILE_NAME_REGEX)) {
                return fileName;
            } else {
                System.out.print("Invalid file name. Please enter file name without following characters: \\ / : * ? \" < > | ");
            }
        }
    }
}
