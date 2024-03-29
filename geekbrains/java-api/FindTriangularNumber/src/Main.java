import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter natural number to find its triangular number: ");
        int n = validateIntInput();
        TriangularNum.calculateTriangNum(n);

        System.out.print("Enter triangular number to check: ");
        int m = validateIntInput();
        if (TriangularNum.isTriangular(m)) {
            System.out.print("Number is triangular");
        } else {
            System.out.print("Number is not triangular");
        }
    }

    public static int validateIntInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "^[0-9]\\d*$";

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
