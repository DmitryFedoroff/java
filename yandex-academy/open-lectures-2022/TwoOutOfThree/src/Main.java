import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final int LIST_LENGTH = 1;
        Scanner scanner = new Scanner(System.in);
        InputValidator listLengthValidator = new NaturalNumberValidator(LIST_LENGTH, scanner);

        Set<Integer> firstSet = getUserInput(listLengthValidator, "first", scanner);
        Set<Integer> secondSet = getUserInput(listLengthValidator, "second", scanner);
        Set<Integer> thirdSet = getUserInput(listLengthValidator, "third", scanner);

        CommonNumberFinder finder = new CommonNumberFinder();
        Set<Integer> commonNumbers = finder.findCommonNumbers(firstSet, secondSet, thirdSet);

        scanner.close();
    }

    private static Set<Integer> getUserInput(InputValidator listLengthValidator, String listName, Scanner scanner) {
        System.out.print("Enter length of " + listName + " list: ");
        List<Integer> listLengths = listLengthValidator.validate();
        int listLength = listLengths.get(0);

        InputValidator listValidator = new NaturalNumberValidator(listLength, scanner);

        System.out.print("Enter natural numbers separated by whitespace for " + listName + " list: ");
        List<Integer> list = listValidator.validate();
        Set<Integer> resultSet = list.stream().collect(Collectors.toSet());
        return resultSet;
    }
}
