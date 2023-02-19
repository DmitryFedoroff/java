public class GameAlgo {

    public static void moveDisk(char src, char dest, char buff, int count) {
        if (count == 1) {
            System.out.printf("from %s to %s%n", src, dest);
        } else {
            moveDisk(src, buff, dest, count - 1);
            System.out.printf("from %s to %s%n", src, dest);
            moveDisk(buff, dest, src, count - 1);
        }
    }
}
