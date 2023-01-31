import java.util.HashSet;
import java.util.Set;

public class UniqueSums {

    public static int findUnique(int[] arr) {
        Set<Integer> s = new HashSet<>();
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                s.add(arr[i] + arr[j]);
            }
        }
        return s.size();
    }
}
