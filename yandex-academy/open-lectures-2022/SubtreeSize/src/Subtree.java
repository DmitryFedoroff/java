import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subtree {

    public int calculateSubtreeSizes(int vertex, List<List<Integer>> adjacencyList, int[] subtreeSizes) {
        subtreeSizes[vertex] = 1;

        for (int adjacentVertex : adjacencyList.get(vertex)) {
            if (subtreeSizes[adjacentVertex] == -1) {
                subtreeSizes[vertex] += calculateSubtreeSizes(adjacentVertex, adjacencyList, subtreeSizes);
            }
        }
        return subtreeSizes[vertex];
    }

    public int[] storeSubtreeSizes(int n, ConnVertInputValidator connVertInputValidator) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print("Enter pair of numbers (vertices connected by edge): ");
            int[] vertices = connVertInputValidator.validate();

            adjacencyList.get(vertices[0]).add(vertices[1]);
            adjacencyList.get(vertices[1]).add(vertices[0]);
        }

        int[] subtreeSizes = new int[n + 1];
        Arrays.fill(subtreeSizes, -1);

        calculateSubtreeSizes(1, adjacencyList, subtreeSizes);

        int[] result = new int[n];

        System.arraycopy(subtreeSizes, 1, result, 0, n);
        return result;
    }

    public String print(int[] ans) {
        StringBuilder sb = new StringBuilder();

        for (int an : ans) {
            sb.append(an).append(" ");
        }
        return sb.toString();
    }
}