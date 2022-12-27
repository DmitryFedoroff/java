import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = scan.nextLine();

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("String is null or empty or whitespace.");
        }

        System.out.println("Your string is: " + input);
        scan.close();
    }
}
