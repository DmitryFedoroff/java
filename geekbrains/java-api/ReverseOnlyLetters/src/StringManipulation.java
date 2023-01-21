public class StringManipulation {

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
