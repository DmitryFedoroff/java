import java.util.List;

public class Subtree {

    public static int calculateSubtreeSizes(int vertex, List<List<Integer>> adjacencyList, int[] subtreeSizes) {
        subtreeSizes[vertex] = 1;

        for (int adjacentVertex : adjacencyList.get(vertex)) {
            if (subtreeSizes[adjacentVertex] == -1) {
                subtreeSizes[vertex] += calculateSubtreeSizes(adjacentVertex, adjacencyList, subtreeSizes);
            }
        }
        return subtreeSizes[vertex];
    }
}
