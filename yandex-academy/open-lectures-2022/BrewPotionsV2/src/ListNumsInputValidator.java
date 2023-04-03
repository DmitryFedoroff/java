import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ListNumsInputValidator implements InputValidatable<List<Integer>> {

    private Scanner scan = new Scanner(System.in);
    private int size;

    public ListNumsInputValidator(int size) {
        this.size = size;
    }

    public List<Integer> validate() {
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

        List<Integer> inputIntegers = new ArrayList<>();

        for (String number : inputNumbers) {
            inputIntegers.add(Integer.parseInt(number));
        }
        return inputIntegers;
    }

    public void closeScanner() {
        scan.close();
    }
}