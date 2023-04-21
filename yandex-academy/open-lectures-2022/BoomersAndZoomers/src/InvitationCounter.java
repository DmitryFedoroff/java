import java.util.Arrays;

public class InvitationCounter {

    public int countInvites(int people, int[] ages) {
        int left = 0;
        int right = 0;
        int result = 0;

        Arrays.sort(ages);

        for (int i = 0; i < people; i++) {
            while (left < people && ages[left] <= 0.5 * ages[i] + 7) {
                left++;
            }
            while (right < people && ages[right] <= ages[i]) {
                right++;
            }
            if (right > left + 1) {
                result += right - left - 1;
            }
        }
        return result;
    }
}