package errorhandler;

import exceptions.FileReadingException;
import exceptions.InvalidFileDataException;

public class BasicErrorHandler implements ErrorHandlerInterface {
    @Override
    public void handleException(Exception e) {
        if (e instanceof FileReadingException) {
            System.out.println(e.getMessage());
        } else if (e instanceof InvalidFileDataException) {
            System.out.println(e.getMessage());
        }
    }
}
