public class PalindromeBreaker {

    public static String breakPalindrome(String s) {
        if (s.length() == 1) {
            return "";
        }

        int middle = s.length() / 2;
        boolean flag = false;
        String ans = "";

        for (int i = 0; i < middle; i++) {
            if (s.charAt(i) != 'a') {
                ans = s.substring(0, i) + "a" + s.substring(i+1);
                flag = true;
                break;
            }
        }

        if (flag) {
            return ans;
        } else {
            return s.substring(0, s.length()-1) + "b";
        }
    }
}
