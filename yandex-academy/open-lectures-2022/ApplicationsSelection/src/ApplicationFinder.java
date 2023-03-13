public class ApplicationFinder {

    private static int[][] getApplications(int n, InputValidatable<int[]> validator) {
        int[][] applications = new int[n][2];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter two natural numbers si and fi: ");
            int[] siFi = validator.validate();
            applications[i] = siFi;
        }
        return applications;
    }
}