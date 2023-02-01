import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter number of array rows: ");
        int n = validateIntInput();
        System.out.print("Enter number of array columns: ");
        int m = validateIntInput();
        int[][] array = ArrayManipulation.create(n, m);

        System.out.println("Original array:");
        ArrayManipulation.print(array);
        ArrayManipulation.bubbleSortRow(array);
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
