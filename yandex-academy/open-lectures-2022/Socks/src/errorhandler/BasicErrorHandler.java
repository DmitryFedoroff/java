package errorhandler;

import exceptions.FileReadingException;

public class BasicErrorHandler implements ErrorHandlerInterface {
    @Override
    public void handleException(Exception e) {
        if (e instanceof FileReadingException) {
            System.out.println(e.getMessage());
        }
    }
}
