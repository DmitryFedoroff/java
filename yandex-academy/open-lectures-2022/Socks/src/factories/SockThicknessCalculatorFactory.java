package factories;

import function.SockThicknessCalculator;
import function.SockThicknessCalculatorInterface;
import java.util.List;

public class SockThicknessCalculatorFactory implements ThicknessCalculatorFactoryInterface {
    @Override
    public SockThicknessCalculatorInterface create(int l, int n, int m, List<String> fileLines, List<Integer> pointsOfInterest) {
        return new SockThicknessCalculator(l, n, m, fileLines, pointsOfInterest);
    }
}
