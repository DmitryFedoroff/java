public class Main {

    public static void main(String[] args) {
        NatNumInputValidator natNumInputValidator = new NatNumInputValidator();

        System.out.print("Enter number of stalls: ");
        int numOfStalls = natNumInputValidator.validate();

        System.out.print("Enter number of cows: ");
        int numOfCows = natNumInputValidator.validate();

        ArrayNumsInputValidator arrayNumsInputValidator = new ArrayNumsInputValidator(numOfStalls);

        System.out.print("Enter stalls coordinates in ascending order: ");
        int[] stallCoords = arrayNumsInputValidator.validate();

        CowStallDistanceFinder cowStallDistanceFinder = new CowStallDistanceFinder();
    }
}