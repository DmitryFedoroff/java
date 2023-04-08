public class Main {

    public static void main(String[] args) {
        LatinLowerCaseInputValidator latinLowerCaseInputValidator = new LatinLowerCaseInputValidator();

        System.out.print("Enter 1st string: ");
        String s = latinLowerCaseInputValidator.validate();

        System.out.print("Enter 2nd string: ");
        String t = latinLowerCaseInputValidator.validate();

        AnagramChecker anagramChecker = new AnagramChecker();

        System.out.print("Are given strings anagrams? ");
        anagramChecker.checkAndPrintResult(s, t);

        latinLowerCaseInputValidator.closeScanner();
    }
}