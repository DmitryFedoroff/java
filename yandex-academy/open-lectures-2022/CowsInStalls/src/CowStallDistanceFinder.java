public class CowStallDistanceFinder {

    public int binarySearch(int k, int[] coords) {
        int leftBound = 0;
        int rightBound = coords[coords.length - 1];

        while (rightBound > leftBound) {
            int distance = (leftBound + rightBound + 1) / 2;
            if (countCows(distance, k, coords)) {
                leftBound = distance;
            } else {
                rightBound = distance - 1;
            }
        }
        return leftBound;
    }

    public boolean countCows(int distance, int k, int[] coords) {
        int counter = 1;
        int prevPos = coords[0];

        for (int i = 1; i < coords.length; i++) {
            if (coords[i] - prevPos >= distance) {
                counter++;
                prevPos = coords[i];
            }
        }
        return counter >= k;
    }
}