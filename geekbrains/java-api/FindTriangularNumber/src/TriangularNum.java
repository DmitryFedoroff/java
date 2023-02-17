public class TriangularNum {

    public static void calculateTriangNum(int num) {
        if (num > 0) {
            int triangular = num * (num + 1) / 2;
            System.out.println("Triangular number for " + num + " is " + triangular);
        } else {
            System.out.println("0 is not natural number. Enter natural number, i.e., 1, 2, 3, ...");
        }
        System.out.println();
    }

    static boolean isTriangular(int originalNum) {
        if (originalNum < 0) {
            return false;
        }

        int sum = 0;

        for (int i = 1; sum <= originalNum; i++) {
            sum = sum + i;
            if (sum == originalNum)
                return true;
        }
        return false;
    }
}
