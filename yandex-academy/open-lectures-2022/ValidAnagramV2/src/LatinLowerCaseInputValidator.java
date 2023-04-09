import java.util.Scanner;

public class LatinLowerCaseInputValidator implements InputValidatable {

    private Scanner scan = new Scanner(System.in);

    public String validate() {
        String input = scan.nextLine();
        String regex = "^[a-z]+$";

        while (input.trim().isEmpty() || !input.matches(regex)) {
            System.out.println("Input value is not small Latin letters");
            System.out.print("Please try again: ");
            input = scan.nextLine();
        }
        return input;
    }

    public void closeScanner() {
        scan.close();
    }
}