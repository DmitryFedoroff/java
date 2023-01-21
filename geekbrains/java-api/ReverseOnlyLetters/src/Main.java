import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String myStr = validateStrInput();

        StringManipulation.createReversedString(myStr);
    }

    public static String validateStrInput() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter string to reverse: ");
        String input = scan.nextLine();

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is null or empty or whitespace");
        }
        scan.close();
        return input;
    }
}
