import java.util.Scanner;

public class ArrayLenInputValidator implements InputValidatable<Integer> {

    private Scanner scanner = new Scanner(System.in);

    public Integer validate() {
        String input = scanner.nextLine();
        String regex = "^[1-9]\\d*$";

        while (input.trim().isEmpty() || !input.matches(regex)) {
            System.out.println("Input value is not a natural number");
            System.out.print("Please try again: ");
            return validate();
        }
        return Integer.parseInt(input);
    }

    public void closeScanner() {
        scanner.close();
    }
}