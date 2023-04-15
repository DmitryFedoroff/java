import java.util.Arrays;

public class ClassroomSeating {

    public static int getMaxSeatedGroups(int[] roomCaps, int[] groupSizes) {
        Arrays.sort(groupSizes);
        Arrays.sort(roomCaps);

        int currPos = 0;
        int seatedGroups = 0;

        for (int groupSize : groupSizes) {
            while (currPos < roomCaps.length && roomCaps[currPos] < groupSize) {
                currPos++;
            }
            if (currPos != roomCaps.length) {
                seatedGroups++;
                currPos++;
            }
        }
        return seatedGroups;
    }
}