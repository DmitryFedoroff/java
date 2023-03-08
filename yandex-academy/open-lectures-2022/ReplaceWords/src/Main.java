import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words from dictionary: ");
        Set<String> dictionary = new HashSet<>(Arrays.asList(scanner.nextLine().split(" ")));

        List<String> replacedWords = WordReplacer.replaceWords(dictionary);

        System.out.println("Text with replacements: " + String.join(" ", replacedWords));
        scanner.close();
    }
}
