import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String myStr = validateStrInput();

        System.out.print(PalindromeValid.isPalindrome(myStr));
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
