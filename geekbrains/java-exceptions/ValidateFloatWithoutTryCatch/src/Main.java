import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        float fNum = inputFloat();
    }

    public static float inputFloat() {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter floating point number: ");
        String input = scan.next();

        while (!input.matches("[+-]?[0-9]+\\.[0-9]+")) {
            System.out.println("Input is not floating point number.");
            System.out.print("Please try again: ");
            input = scan.next();
        }
        scan.close();
        return Float.parseFloat(input);
    }
}
