import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter number of disks: ");
        int n = validateIntInput();
    }

    public static int validateIntInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "^[1-9]\\d*$";

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is null or empty or whitespace");
        }

        while (!input.matches(regex)) {
            System.out.println("Number of disks is not positive integer or zero");
            System.out.print("Please try again: ");
            input = scan.next();
        }
        return Integer.parseInt(input);
    }
}
