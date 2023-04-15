import java.util.Scanner;

public class ArrayNumsInputValidator implements InputValidatable<int[]> {

    private Scanner scanner = new Scanner(System.in);
    private int size;

    public ArrayNumsInputValidator(int size) {
        this.size = size;
    }

    public int[] validate() {
        String input = scanner.nextLine();
        String regex = "^[1-9]\\d*(\\s[1-9]\\d*)*$";

        while (input.trim().isEmpty() || !input.matches(regex)) {
            System.out.println("Input values are not natural numbers separated by whitespace");
            System.out.print("Please try again: ");
            input = scanner.nextLine();
        }

        String[] inputNumbers = input.split("\\s+");
        int expectedNumbersCount = size;

        while (inputNumbers.length != expectedNumbersCount) {
            System.out.println("Invalid input. Please enter " + expectedNumbersCount + " natural numbers separated by whitespace.");
            System.out.print("Please try again: ");
            return validate();
        }

        int[] inputIntegers = new int[inputNumbers.length];
        int currentIndex = 0;

        for (String number : inputNumbers) {
            inputIntegers[currentIndex++] = Integer.parseInt(number);
        }
        return inputIntegers;
    }

    public void closeScanner() {
        scanner.close();
    }
}