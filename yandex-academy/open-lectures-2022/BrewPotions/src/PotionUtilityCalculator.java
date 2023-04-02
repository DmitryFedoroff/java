import java.util.Arrays;

public class PotionUtilityCalculator {
    private static final int INF = (int) 1e18;
    private static final int MAX_ELEM = (int) 1e9;

    private int n;
    private int k;
    private int[] utility;

    public PotionUtilityCalculator(int n, int k, int[] utility) {
        this.n = n;
        this.k = k;
        this.utility = utility;
    }

    public int calcUtility(int minUtil) {
        int result = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (utility[i] < minUtil) {
                break;
            }
            count++;
            result += utility[i];
        }

        int j = 2;

        while ((j <= n) && (utility[0] + utility[j-1] >= minUtil)) {
            j++;
        }

        int[] prefSum = new int[n+1];

        for (int i = 1; i <= n; i++) {
            prefSum[i] = prefSum[i - 1] + utility[i-1];
        }

        for (int i = 1; i <= n; i++) {
            if (i + 1 >= j) {
                break;
            }
            while ((j - 1 > i) && (utility[i-1] + utility[j - 2] < minUtil)) {
                j--;
            }
            count += (j - i - 1);
            result += prefSum[j - 1] - prefSum[i] + utility[i-1] * (j - i - 1);
        }

        if (count >= k) {
            return result - (count - k) * minUtil;
        } else {
            return INF;
        }
    }

    public int binarySearch() {
        Arrays.sort(utility);
        reverseArray(utility);

        int leftBound = -MAX_ELEM;
        int rightBound = MAX_ELEM;

        while (rightBound > leftBound) {
            int m = (leftBound + rightBound + 1) / 2;
            if (calcUtility(m) != INF) {
                leftBound = m;
            } else {
                rightBound = m - 1;
            }
        }
        return leftBound;
    }

    private void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}