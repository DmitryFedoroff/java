import java.util.Arrays;
import java.util.Comparator;

public class ApplicationFinder {

    public int findMaxApplications(int n, InputValidatable<int[]> validator) {
        int[][] applications = getApplications(n, validator);
        Arrays.sort(applications, Comparator.comparingInt(a -> a[1]));
        int end = applications[0][1];
        int count = 1;

        for (int i = 1; i < applications.length; i++) {
            if (applications[i][0] >= end) {
                count++;
                end = applications[i][1];
            }
        }
        return count;
    }

    private int[][] getApplications(int n, InputValidatable<int[]> validator) {
        int[][] applications = new int[n][2];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter two natural numbers si and fi: ");
            int[] siFi = validator.validate();
            applications[i] = siFi;
        }
        return applications;
    }
}