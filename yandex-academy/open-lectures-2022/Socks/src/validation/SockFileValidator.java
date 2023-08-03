package validation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class SockFileValidator implements SockFileValidatorInterface {
    private String filePath;

    public SockFileValidator(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean isFileValid() {
        Path file = Path.of(filePath);

        if (!Files.exists(file)) {
            System.out.println("Sock data file " + filePath + " does not exist.");
            return false;
        }
        if (Files.isDirectory(file)) {
            System.out.println(filePath + " is a directory");
            return false;
        }
        try {
            if (Files.size(file) == 0) {
                System.out.println("Sock data file " + filePath + " is empty.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading sock data file.");
            return false;
        }
        return true;
    }

    @Override
    public void notifyFileReadSuccessfully() {
        System.out.println("Sock data file read successfully.");
    }
}
