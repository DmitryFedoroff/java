public class Main {

    public static void main(String[] args) {
        TotalVertInputValidator totalVertInputValidator = new TotalVertInputValidator();
        ConnVertInputValidator connVertInputValidator = new ConnVertInputValidator();

        System.out.print("Enter the number of vertices: ");
        int numVertices = totalVertInputValidator.validate();

        int[] result = Subtree.storeSubtreeSizes(numVertices, connVertInputValidator);

        System.out.print("Size of subtree for each vertex: " + Subtree.print(result));

        totalVertInputValidator.closeScanner();
        connVertInputValidator.closeScanner();
    }
}