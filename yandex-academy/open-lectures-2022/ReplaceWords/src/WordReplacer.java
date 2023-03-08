import java.util.*;

public class WordReplacer {

    public static List<String> replaceWords(Set<String> dictionary) {
        List<String> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words of text: ");
        String[] words = scanner.nextLine().split(" ");
        scanner.close();

        for (String word : words) {
            boolean replaced = false;
            int i = 1;
            while (i <= Math.min(100, word.length()) && !replaced) {
                String prefix = word.substring(0, i);
                if (dictionary.contains(prefix)) {
                    result.add(prefix);
                    replaced = true;
                }
                i++;
            }
            if (!replaced) {
                result.add(word);
            }
        }
        return result;
    }
}
