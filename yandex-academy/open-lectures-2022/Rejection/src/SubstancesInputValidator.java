import java.util.Scanner;

public class SubstancesInputValidator implements InputValidatable<String[]> {

    private Scanner scanner = new Scanner(System.in);
    private int size;

    public SubstancesInputValidator(int size) {
        this.size = size;
    }

    @Override
    public String[] validate() {
        String input = scanner.nextLine();
        String regex = "^[a-zA-Z\\s]+$";

        while (input.trim().isEmpty() || !input.matches(regex)) {
            System.out.println("Input values are not valid chemical substance formulas separated by whitespace");
            System.out.print("Please try again: ");
            input = scanner.nextLine();
        }

        String[] inputSubstances = input.split("\\s+");

        while (inputSubstances.length != size) {
            System.out.println("Invalid input. Please enter " + size + " chemical substance formulas separated by whitespace");
            System.out.print("Please try again: ");
            return validate();
        }
        return inputSubstances;
    }

    public void closeScanner() {
        scanner.close();
    }
}
