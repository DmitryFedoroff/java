import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter number of blocks: ");
        int n = validateIntInput();

        System.out.print("Maximum number of steps in staircase: " + Staircase.countSteps(n));
    }

    public static int validateIntInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "^[1-9]\\d*$";

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is null or empty or whitespace");
        }

        while (!input.matches(regex)) {
            System.out.println("Input value is not positive integer or zero");
            System.out.print("Please try again: ");
            input = scan.next();
        }
        return Integer.parseInt(input);
    }
}