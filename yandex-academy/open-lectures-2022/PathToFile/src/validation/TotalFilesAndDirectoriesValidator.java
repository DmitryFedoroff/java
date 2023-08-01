package validation;

import java.util.Scanner;

public class TotalFilesAndDirectoriesValidator implements FileNameValidator, FilesAndDirectoriesValidator {
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

    @Override
    public String[] validateFilesAndDirectories(int expectedCount) {
        String[] lines = new String[expectedCount];

        for (int i = 0; i < expectedCount; i++) {
            lines[i] = scanner.nextLine();
        }
        return lines;
    }
}