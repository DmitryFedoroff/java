import java.util.Scanner;

public class AbsoluteAddrInputValidator implements InputValidatable {

    private Scanner scan = new Scanner(System.in);

    public String validate() {
        String input = scan.nextLine();
        String regex = "^/((\\w+|\\.{2,}|(\\.{1})?)/)*(\\w+|\\.{2,}|(\\.{1})?)$";

        while (input.trim().isEmpty() || !input.matches(regex)) {
            System.out.println("Input value is not absolute address");
            System.out.print("Please try again: ");
            input = scan.nextLine();
        }
        return input;
    }

    public void closeScanner() {
        scan.close();
    }
}