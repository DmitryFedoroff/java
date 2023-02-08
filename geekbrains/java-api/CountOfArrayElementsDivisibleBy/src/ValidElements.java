public class ValidElements {

    public static void countElemDivBy(int[] arr) {
        int len = arr.length;
        String validElem = "";
        int count = 0;

        for (int i = 0; i < len; i++) {
            int p = arr[i];
            int sum = 0;
            int prod = 1;

            while (p > 0) {
                int r = p % 10;
                sum += r;
                prod *= r;
                p /= 10;
            }

            if ((sum > 0 && arr[i] % sum == 0) || (prod > 0 && arr[i] % prod == 0)) {
                validElem += arr[i] + " ";
                count++;
            }
        }
        System.out.println("Number of elements divisible by their product or sum of digits: " + count);
        System.out.println("Elements divisible by their product or sum of digits: " + validElem);
    }
}
