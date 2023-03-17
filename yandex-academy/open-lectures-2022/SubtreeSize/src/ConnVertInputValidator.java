import java.util.Scanner;

public class ConnVertInputValidator implements InputValidatable<int[]> {

    private Scanner scan = new Scanner(System.in);

    public int[] validate() {
        String input = scan.nextLine();
        String regex = "^[1-9]\\d*(\\s[1-9]\\d*)*$";

        while (input.trim().isEmpty() || !input.matches(regex)) {
            System.out.println("Input values are not pair of natural numbers separated by whitespace");
            System.out.print("Please try again: ");
            input = scan.nextLine();
        }

        String[] vertices = input.split("\\s+");
        int size = 2;

        while (vertices.length != size) {
            System.out.println("Invalid input. Please enter only pair of natural numbers separated by whitespace");
            System.out.print("Please try again: ");
            input = scan.nextLine();
            vertices = input.split("\\s+");
        }

        int[] result = new int[size];
        int i = 0;

        for (String vertex : vertices) {
            result[i++] = Integer.parseInt(vertex);
        }
        return result;
    }

    public void closeScanner() {
        scan.close();
    }
}
