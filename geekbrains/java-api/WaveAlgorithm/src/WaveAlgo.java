public class WaveAlgo {

    public static void printArray(int[][] arr) {

        int lenRow = arr.length;
        int lenCol = arr[0].length;

        for (int i = 0; i < lenRow; i++) {
            for(int j = 0; j < lenCol; j++) {
                System.out.print(arr[i][j] + " ");
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
