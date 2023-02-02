public class FiboSequence {

    public static int[] fillFibo(int[] fiboNums, int numsLimit) {
        if (numsLimit > 2) {
            fiboNums[0] = 0;
            fiboNums[1] = 1;
            for (int i = 2; i < fiboNums.length; i++) {
                fiboNums[i] = fiboNums[i - 2] + fiboNums[i - 1];
            }
        } else if (numsLimit == 2) {
            fiboNums[0] = 0;
            fiboNums[1] = 1;
        }
        return fiboNums;
    }
}
