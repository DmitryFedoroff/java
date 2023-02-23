import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter palindrome: ");
        String myStr = validateStrInput();
        System.out.printf("Broken palindrome: %s", PalindromeBreaker.breakPalindrome(myStr));
    }

    public static String validateStrInput() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter palindrome: ");
        String input = scan.nextLine();

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is null or empty or whitespace");
        }
        scan.close();
        return input;
    }
}
