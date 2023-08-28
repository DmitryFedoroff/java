package factories;

import validation.SockFileValidator;
import validation.SockFileValidatorInterface;

public class SockFileValidatorFactory implements FileValidatorFactoryInterface {
    @Override
    public SockFileValidatorInterface create(String filePath) {
        return new SockFileValidator(filePath);
    }
}
