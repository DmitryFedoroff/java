import java.util.StringJoiner;

public class StringManipulation {

    public static void createReversedString(String StringToReverse) {
        StringJoiner sj = new StringJoiner(" ");

        for (String part : StringToReverse.split(" ")) {
            sj.add(reverseLetters(part.toString()));
        }
        System.out.print("Reversed string: " + sj);
    }

    public static String reverseLetters(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (start < end && !Character.isLetter(s.charAt(start))) {
                ++start;
            }
            if (start < end && !Character.isLetter(s.charAt(end))) {
                --end;
            }
            swap(chars, start, end);
            start++;
            end--;
        }
        return String.valueOf(chars);
    }

    static void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
