import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Subtree {

    public static int[] storeSubtreeSizes(int numberOfVertices) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < numberOfVertices - 1; i++) {
            System.out.print("Enter pairs of numbers (vertices connected by an edge): ");
            Scanner input = new Scanner(System.in);
            int vertexA = input.nextInt();
            int vertexB = input.nextInt();

            adjacencyList.get(vertexA).add(vertexB);
            adjacencyList.get(vertexB).add(vertexA);
        }

        int[] subtreeSizes = new int[numberOfVertices + 1];
        Arrays.fill(subtreeSizes, -1);

        calculateSubtreeSizes(1, adjacencyList, subtreeSizes);

        int[] result = new int[numberOfVertices];

        for (int i = 1; i <= numberOfVertices; i++) {
            result[i - 1] = subtreeSizes[i];
        }
        return result;
    }

    public static int calculateSubtreeSizes(int vertex, List<List<Integer>> adjacencyList, int[] subtreeSizes) {
        subtreeSizes[vertex] = 1;

        for (int adjacentVertex : adjacencyList.get(vertex)) {
            if (subtreeSizes[adjacentVertex] == -1) {
                subtreeSizes[vertex] += calculateSubtreeSizes(adjacentVertex, adjacencyList, subtreeSizes);
            }
        }
        return subtreeSizes[vertex];
    }

    public static void print(int[] ans) {
        int len = ans.length;

        for (int i = 0; i < len; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
