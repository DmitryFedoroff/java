import java.util.HashMap;
import java.util.Map;

public class MajorityElementFinder {

    public int findMajority(int len, int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        for (int val : count.keySet()) {
            if (count.get(val) > len / 2) {
                return val;
            }
        }
        return -1;
    }
}