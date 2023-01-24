import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float fNum = inputFloat();

        System.out.println("Your floating point number: " + fNum);
    }

    public static float inputFloat() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter floating point number: ");

        while (!scan.hasNextFloat()) {
            System.out.println("Input is not floating point number");
            System.out.print("Please try again: ");
            scan.next();
        }
        return scan.nextFloat();
    }
}
