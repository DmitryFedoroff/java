public class Main {

    public static void main(String[] args) {
        TotalVertInputValidator totalVertInputValidator = new TotalVertInputValidator();
        ConnVertInputValidator connVertInputValidator = new ConnVertInputValidator();

        System.out.print("Enter the number of vertices: ");
        int numVertices = totalVertInputValidator.validate();

        Subtree subtree = new Subtree();
        int[] result = subtree.storeSubtreeSizes(numVertices, connVertInputValidator);

        System.out.print("Size of subtree for each vertex: " + subtree.print(result));

        totalVertInputValidator.closeScanner();
        connVertInputValidator.closeScanner();
    }
}