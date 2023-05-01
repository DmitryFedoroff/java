import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int NUM_NK_VALUES = 2;
        InputValidator nkValuesValidator = new NonNegativeIntegerListValidator(NUM_NK_VALUES);

        System.out.print("Enter n and k: ");
        List<Integer> nkValues = nkValuesValidator.validate();
        int n = nkValues.get(0);
        int k = nkValues.get(1);

        InputValidator numsValidator = new NonNegativeIntegerListValidator(n);

        System.out.print("Enter numbers: ");
        List<Integer> nums = numsValidator.validate();

        NumberRepetitionChecker repetitionChecker = new NumberRepetitionChecker();
        boolean hasRepetition = repetitionChecker.hasRepeatingNumberWithinDistance(nums, k);
    }
}