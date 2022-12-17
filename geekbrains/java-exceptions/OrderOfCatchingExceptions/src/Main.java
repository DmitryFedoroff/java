public class Main {

    public static void main(String[] args) {

        int[] abc = { 1, 2 };
        abc[3] = 9;
        int a = 90;
        int b = 3;

        try {
            System.out.println(a / b);
            printSum(23, 234);
        } catch (NullPointerException ex) {
            System.out.println("Attempt to access reference variable that currently points to null.");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Array accessed with illegal index.");
        } catch (Throwable ex) {
            System.out.println("Something went wrong...");
        }
    }
}
