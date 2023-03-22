import java.util.Scanner;

public class DailyPriceInputValidator implements InputValidatable<int[]> {

    private Scanner scan = new Scanner(System.in);
    private int size;

    public DailyPriceInputValidator(int size) {
        this.size = size;
    }

    public int[] validate() {
        String input = scan.nextLine();
        String regex = "^[1-9]\\d*(\\s[1-9]\\d*)*$";

        while (input.trim().isEmpty() || !input.matches(regex)) {
            System.out.println("Input values are not natural numbers separated by whitespace");
            System.out.print("Please try again: ");
            input = scan.nextLine();
        }

        String[] prices = input.split("\\s+");

        while (prices.length != size) {
            System.out.println("Invalid input. Please enter " + size + " natural numbers separated by whitespace");
            System.out.print("Please try again: ");
            return validate();
        }

        int[] result = new int[prices.length];
        int i = 0;

        for (String price : prices) {
            result[i++] = Integer.parseInt(price);
        }
        return result;
    }

    public void closeScanner() {
        scan.close();
    }
}