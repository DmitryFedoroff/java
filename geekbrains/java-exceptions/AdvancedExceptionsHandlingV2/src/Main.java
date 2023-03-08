import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            processUserInput();
        } catch (WrongParsingDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void processUserInput() throws WrongParsingDataException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter following data separated by whitespace:");
        System.out.println("LastName FirstName PatronymicName BirthDate PhoneNumber Gender:");

        String input = scanner.nextLine();

        UserData userData;
        try {
            userData = UserInputParser.parse(input);
        } finally {
            scanner.close();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userData.getLastName() + ".txt", true))) {
            writer.write(userData.toString());
            writer.newLine();
            writer.flush();
            System.out.println("Data was successfully written to file: " + userData.getLastName() + ".txt");
        } catch (IOException e) {
            throw new WrongParsingDataException("Error writing to file: " + e.getMessage(), e);
        }
    }
}
