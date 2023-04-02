import java.util.Scanner;

public class NatNumInputValidator implements InputValidatable<Integer> {

    private Scanner scan = new Scanner(System.in);

    public Integer validate() {
        String input = scan.nextLine();
        String regex = "^[1-9]\\d*$";

        while (input.trim().isEmpty() || !input.matches(regex)) {
            System.out.println("Input value is not natural number");
            System.out.print("Please try again: ");
            return validate();
        }
        return Integer.parseInt(input);
    }

    public void closeScanner() {
        scan.close();
    }
}
