import java.util.Arrays;

public class AnagramChecker {

    public void checkAndPrintResult(String s, String t) {
        boolean isAnagram = isAnagram(s, t);

        if (isAnagram) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private boolean isAnagram(String s, String t) {
        return sortString(s).equals(sortString(t));
    }

    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}