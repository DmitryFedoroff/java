public class Main {

    public static void main(String[] args) {
        LatinCyrillicInputValidator latinCyrillicInputValidator = new LatinCyrillicInputValidator();

        System.out.print("Enter palindrome: ");
        String str = latinCyrillicInputValidator.validate();

        PalindromeBreaker palindromeBreaker = new PalindromeBreaker();
        String result = palindromeBreaker.breakPalindrome(str);

        System.out.println("Broken palindrome: " + result);

        latinCyrillicInputValidator.closeScanner();
    }
}
