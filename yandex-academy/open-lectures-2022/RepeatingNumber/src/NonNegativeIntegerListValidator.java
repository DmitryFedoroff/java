import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NonNegativeIntegerListValidator implements InputValidator {

    private static final String NON_NEGATIVE_INTEGER_REGEX = "^(0|[1-9]\\d*)(\\s(0|[1-9]\\d*))*$";

    private Scanner scanner = new Scanner(System.in);
    private int size;

    public NonNegativeIntegerListValidator(int size) {
        this.size = size;
    }

    @Override
    public List<Integer> validate() {
        while (true) {
            String input = scanner.nextLine();

            if (input.trim().isEmpty() || !input.matches(NON_NEGATIVE_INTEGER_REGEX)) {
                System.out.println("Input values are not non-negative integers separated by whitespace");
                System.out.print("Please try again: ");
                continue;
            }

            String[] inputNumbers = input.split("\\s+");
            List<Integer> inputIntegers = new ArrayList<>();

            for (String number : inputNumbers) {
                inputIntegers.add(Integer.parseInt(number));
            }

            if (inputIntegers.size() != size) {
                System.out.println("Invalid input. Please enter " + size + " non-negative integers separated by whitespace");
                System.out.print("Please try again: ");
            } else {
                return inputIntegers;
            }
        }
    }

    @Override
    public void closeScanner() {
        scanner.close();
    }
}