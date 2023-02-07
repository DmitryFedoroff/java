public class ConvertedNumber {

    public static int findArrSize(int num) {
        int temp = num;
        int count = 0;

        while (temp != 0) {
            temp = temp / 2;
            count++;
        }
        return count;
    }
}
