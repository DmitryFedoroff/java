import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NaturalNumberValidator implements InputValidator {

    private static final String NATURAL_NUMBER_REGEX = "^[1-9]\\d*(\\s[1-9]\\d*)*$";

    private Scanner scanner;
    private int listSize;

    public NaturalNumberValidator(int listSize, Scanner scanner) {
        this.listSize = listSize;
        this.scanner = scanner;
    }

    @Override
    public List<Integer> validate() {
        while (true) {
            String input = scanner.nextLine();

            if (input.trim().isEmpty() || !input.matches(NATURAL_NUMBER_REGEX)) {
                System.out.println("Input values are not natural numbers separated by whitespace");
                System.out.print("Please try again: ");
                continue;
            }

            String[] inputNumbers = input.split("\\s+");
            List<Integer> inputIntegers = new ArrayList<>();

            for (String number : inputNumbers) {
                inputIntegers.add(Integer.parseInt(number));
            }

            if (inputIntegers.size() != listSize) {
                System.out.println("Invalid input. Please enter " + listSize + " natural numbers separated by whitespace");
                System.out.print("Please try again: ");
            } else {
                return inputIntegers;
            }
        }
    }
}
