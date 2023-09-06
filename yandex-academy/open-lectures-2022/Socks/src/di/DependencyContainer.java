package di;

import factories.FileValidatorFactoryInterface;
import factories.SockFileValidatorFactory;
import factories.ThicknessCalculatorFactoryInterface;
import factories.SockThicknessCalculatorFactory;

public class DependencyContainer {

    public FileValidatorFactoryInterface getFileValidatorFactory() {
        return new SockFileValidatorFactory();
    }

    public ThicknessCalculatorFactoryInterface getThicknessCalculatorFactory() {
        return new SockThicknessCalculatorFactory();
    }
}
