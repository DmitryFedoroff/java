public class Main {

    public static void main(String[] args) {
        NatNumInputValidator natNumInputValidator = new NatNumInputValidator();

        System.out.print("Enter number of ingredients: ");
        int numOfIngredients = natNumInputValidator.validate();

        System.out.print("Enter number of potions: ");
        int numOfPotions = natNumInputValidator.validate();

        ArrayNumsInputValidator arrayNumsInputValidator = new ArrayNumsInputValidator(numOfIngredients);

        System.out.print("Enter ingredients utility (higher number is better): ");
        int[] utility = arrayNumsInputValidator.validate();

        PotionUtilityCalculator potionUtilityCalculator = new PotionUtilityCalculator(numOfIngredients, numOfPotions, utility);
        int result = potionUtilityCalculator.calcUtility(potionUtilityCalculator.binarySearch());
    }
}