import java.util.Scanner;

public class ArrayNumsInputValidator implements InputValidatable<int[]> {

    private Scanner scan = new Scanner(System.in);
    private int size;

    public ArrayNumsInputValidator(int size) {
        this.size = size;
    }

    public int[] validate() {
        String input = scan.nextLine();
        String regex = "^-?[0-9]+( -?[0-9]+)*$";

        while (input.trim().isEmpty() || !input.matches(regex)) {
            System.out.println("Input values are not integer numbers separated by whitespace");
            System.out.print("Please try again: ");
            input = scan.nextLine();
        }

        String[] inputNumbers = input.split("\\s+");
        int expectedNumbersCount = size;

        while (inputNumbers.length != expectedNumbersCount) {
            System.out.println("Invalid input. Please enter " + expectedNumbersCount + " integer numbers separated by whitespace");
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
        scan.close();
    }
}
