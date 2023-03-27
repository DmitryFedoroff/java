import java.util.Arrays;

public class MajorityElementFinder {

    public int findMajority(int len, int[] nums) {
        Arrays.sort(nums);
        return nums[len / 2];
    }
}