import java.util.Scanner;

public class PeopleAgeInputValidator implements InputValidatable<int[]> {

    private Scanner scan = new Scanner(System.in);
    private int size;

    public PeopleAgeInputValidator(int size) {
        this.size = size;
    }

    public int[] validate() {
        String input = scan.nextLine();
        String regex = "^[1-9]\\d*(\\s[1-9]\\d*)*$";

        while (input.trim().isEmpty() || !input.matches(regex)) {
            System.out.println("Input values are not natural numbers separated by whitespace");
            System.out.print("Please try again: ");
            input = scan.nextLine();
        }

        String[] ages = input.split("\\s+");

        while (ages.length > size) {
            System.out.println("Invalid input. Please enter " + size + " natural numbers separated by whitespace");
            System.out.print("Please try again: ");
            return validate();
        }

        int[] result = new int[ages.length];
        int i = 0;

        for (String age : ages) {
            result[i++] = Integer.parseInt(age);
        }
        return result;
    }

    public void closeScanner() {
        scan.close();
    }
}