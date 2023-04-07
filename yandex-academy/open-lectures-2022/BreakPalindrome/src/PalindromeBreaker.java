public class PalindromeBreaker {

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }

        int middle = palindrome.length() / 2;
        boolean hasChanged = false;
        String result = "";

        for (int i = 0; i < middle; i++) {
            if (palindrome.charAt(i) != 'a') {
                result = palindrome.substring(0, i) + "a" + palindrome.substring(i+1);
                hasChanged = true;
                break;
            }
        }

        if (hasChanged) {
            return result;
        } else {
            return palindrome.substring(0, palindrome.length()-1) + "b";
        }
    }
}