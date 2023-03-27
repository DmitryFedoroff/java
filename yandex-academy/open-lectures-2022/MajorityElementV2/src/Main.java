public class Main {

    public static void main(String[] args) {
        ArrayLenInputValidator arrayLenInputValidator = new ArrayLenInputValidator();

        System.out.print("Enter length of array: ");
        int n = arrayLenInputValidator.validate();

        ArrayNumsInputValidator arrayNumsInputValidator = new ArrayNumsInputValidator(n);

        System.out.print("Enter numbers separated by whitespace: ");
        int[] nums = arrayNumsInputValidator.validate();

        MajorityElementFinder majorityElementFinder = new MajorityElementFinder();
        int result = majorityElementFinder.findMajority(n, nums);

        System.out.printf("Majority element in array: " + result);
    }
}