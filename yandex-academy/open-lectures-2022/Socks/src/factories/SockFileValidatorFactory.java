package factories;

import validation.SockFileValidator;
import validation.SockFileValidatorInterface;

public class SockFileValidatorFactory {
    public SockFileValidatorInterface create(String filePath) {
        return new SockFileValidator(filePath);
    }
}
