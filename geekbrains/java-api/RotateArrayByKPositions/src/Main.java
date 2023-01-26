import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[15];
        int len = array.length;

        System.out.print("Enter number of k steps: ");
        int k = validateIntInput();

        for (int i = 0; i < len; i++) {
            array[i] = i + 1;
        }
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("Rotated array: " + Arrays.toString(RotatedArray.rotate(array, k)));
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
