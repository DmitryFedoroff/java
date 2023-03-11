import java.util.Arrays;

public class Invitation {

    public static int countInvites(int n, int[] age) {
        Arrays.sort(age);

        int left = 0;
        int right = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            while (left < n && age[left] <= 0.5 * age[i] + 7) {
                left++;
            }
            while (right < n && age[right] <= age[i]) {
                right++;
            }
            if (right > left + 1) {
                result += right - left - 1;
            }
        }
        return result;
    }
}