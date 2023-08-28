package factories;

import validation.SockFileValidatorInterface;

public interface FileValidatorFactoryInterface {
    SockFileValidatorInterface create(String filePath);
}
