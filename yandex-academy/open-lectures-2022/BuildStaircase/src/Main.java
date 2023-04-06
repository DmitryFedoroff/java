public class Main {

    public static void main(String[] args) {
        NatNumInputValidator natNumInputValidator = new NatNumInputValidator();

        System.out.print("Enter number of blocks: ");
        int n = natNumInputValidator.validate();

        Staircase staircase = new Staircase();
        int steps = staircase.countSteps(n);

        System.out.println("Maximum number of steps in staircase: " + steps);
        staircase.printStaircase(n);

        natNumInputValidator.closeScanner();
    }
}