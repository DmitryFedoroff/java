import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter the number of vertices: ");
        int n = validateIntInput();

        int[] answer = Subtree.storeSubtreeSizes(n);

        System.out.print("Size of subtree for each vertex: ");
        Subtree.print(answer);
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
