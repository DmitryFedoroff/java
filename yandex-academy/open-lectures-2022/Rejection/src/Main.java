public class Main {

    public static void main(String[] args) {
        NatNumInputValidator natNumInputValidator = new NatNumInputValidator();

        System.out.print("Enter number of substances in list of desirable substances: ");
        int desirableSubstancesCount = natNumInputValidator.validate();

        SubstancesInputValidator desirableSubstancesValidator = new SubstancesInputValidator(desirableSubstancesCount);

        System.out.print("Enter list of desirable substances: ");
        String[] desirableSubstances = desirableSubstancesValidator.validate();

        System.out.print("Enter number of substances obtained in reactor: ");
        int reactorSubstancesCount = natNumInputValidator.validate();

        SubstancesInputValidator reactorSubstancesInputValidator = new SubstancesInputValidator(reactorSubstancesCount);

        System.out.print("Enter list of substances obtained in reactor: ");
        String[] reactorSubstances = reactorSubstancesInputValidator.validate();

        SubstanceChecker substanceChecker = new SubstanceChecker(desirableSubstances);
    }
}
