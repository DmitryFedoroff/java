import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Number of people: ");
        int n = validateIntInput()[0];

        System.out.print("Age of people: ");
        int[] age = validateIntInput();
    }

    public static int[] validateIntInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is null or empty or whitespace");
        }

        String[] inputArray = input.trim().split("\\s+");
        int[] result = new int[inputArray.length];
        String regex = "^[1-9]\\d*$";

        for (int i = 0; i < inputArray.length; i++) {
            String inputNumber = inputArray[i];
            if (!inputNumber.matches(regex)) {
                throw new IllegalArgumentException("Input value is not positive integer or zero");
            }
            result[i] = Integer.parseInt(inputNumber);
        }
        return result;
    }
}