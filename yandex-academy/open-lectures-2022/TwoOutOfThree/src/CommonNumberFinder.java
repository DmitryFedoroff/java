import java.util.HashSet;
import java.util.Set;

public class CommonNumberFinder {

    public Set<Integer> findCommonNumbers(Set<Integer> firstSet, Set<Integer> secondSet, Set<Integer> thirdSet) {
        Set<Integer> commonNumbers = findIntersection(firstSet, secondSet);
        Set<Integer> mergedFirstAndSecond = findUnion(firstSet, secondSet);
        commonNumbers = findUnion(commonNumbers, findIntersection(mergedFirstAndSecond, thirdSet));
        return commonNumbers;
    }

    private Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    private Set<Integer> findUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }
}
