import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int year = validateYearInput();
        System.out.print(LeapYear.isLeap(year));
    }

    public static int validateYearInput() {

        Scanner scan = new Scanner(System.in);

        String regex = "\\d{4}";
        System.out.print("Enter leap year: ");
        String input = scan.nextLine();

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is null or empty or whitespace");
        }

        while (!input.matches(regex)) {
            System.out.println("Input value is not year");
            System.out.print("Please try again: ");
            input = scan.next();
        }
        scan.close();
        return Integer.parseInt(input);
    }
}
