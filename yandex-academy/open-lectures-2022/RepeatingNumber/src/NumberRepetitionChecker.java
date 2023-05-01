import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberRepetitionChecker {

    public boolean hasRepeatingNumberWithinDistance(List<Integer> nums, int distance) {
        Set<Integer> lastK = new HashSet<>();

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);

            if (lastK.contains(num)) {
                return true;
            }

            lastK.add(num);

            if (i >= distance) {
                lastK.remove(nums.get(i - distance));
            }
        }
        return false;
    }
}