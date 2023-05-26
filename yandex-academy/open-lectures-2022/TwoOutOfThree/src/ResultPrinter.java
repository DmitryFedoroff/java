import java.util.Set;

public class ResultPrinter {

    public void printResult(Set<Integer> resultSet) {
        String resultString = resultSet.stream()
                .map(String::valueOf)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println("Numbers present in at least two out of three lists: " + resultString + ".");
    }
}
