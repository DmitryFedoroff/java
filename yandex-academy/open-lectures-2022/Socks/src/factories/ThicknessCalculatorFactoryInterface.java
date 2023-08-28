package factories;

import function.SockThicknessCalculatorInterface;
import java.util.List;

public interface ThicknessCalculatorFactoryInterface {
    SockThicknessCalculatorInterface create(int l, int n, int m, List<String> fileLines, List<Integer> pointsOfInterest);
}
