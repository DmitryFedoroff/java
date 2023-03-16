import java.util.Scanner;

public class AppDescInputValidator implements InputValidatable<int[]> {

    private Scanner scan = new Scanner(System.in);

    public int[] validate() {
        String input = scan.nextLine();
        String regex = "^[1-9]\\d*(\\s[1-9]\\d*)*$";

        while (input.trim().isEmpty() || !input.matches(regex)) {
            System.out.println("Input values are not two natural numbers separated by whitespace");
            System.out.print("Please try again: ");
            input = scan.nextLine();
        }

        String[] applications = input.split("\\s+");
        int size = 2;

        while (applications.length != size) {
            System.out.println("Invalid input. Please enter only two natural numbers separated by whitespace");
            System.out.print("Please try again: ");
            input = scan.nextLine();
            applications = input.split("\\s+");
        }

        int si = Integer.parseInt(applications[0]);
        int fi = Integer.parseInt(applications[1]);

        while (si >= fi) {
            System.out.println("Invalid input. First number should be smaller than second number");
            System.out.print("Please try again: ");
            return validate();
        }

        int[] result = new int[size];
        int i = 0;

        for (String app : applications) {
            result[i++] = Integer.parseInt(app);
        }
        return result;
    }

    public void closeScanner() {
        scan.close();
    }
}