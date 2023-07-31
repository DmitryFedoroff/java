package function;

import model.Train;
import java.util.Arrays;

public class TrainTimeDifferenceFinder {
    public static final int MINUTES_IN_DAY = 1440;

    public int findMinDist(int n, String[] timePoints) {
        Train[] trains = new Train[n];

        for (int i = 0; i < n; i++) {
            trains[i] = new Train(timePoints[i]);
        }

        int[] minutePoints = Arrays.stream(trains)
                .mapToInt(Train::getArrivalTimeInMinutes)
                .sorted()
                .toArray();

        int minDist = MINUTES_IN_DAY + minutePoints[0] - minutePoints[n - 1];

        for (int i = 1; i < n; i++) {
            minDist = Math.min(minDist, minutePoints[i] - minutePoints[i - 1]);
        }
        return minDist;
    }
}
