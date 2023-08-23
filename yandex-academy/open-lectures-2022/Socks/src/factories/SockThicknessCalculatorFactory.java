package factories;

import function.SockThicknessCalculator;
import function.SockThicknessCalculatorInterface;
import java.util.List;

public class SockThicknessCalculatorFactory {
    public SockThicknessCalculatorInterface create(int l, int n, int m, String filePath, List<Integer> pointsOfInterest) {
        return new SockThicknessCalculator(l, n, m, filePath, pointsOfInterest);
    }
}
