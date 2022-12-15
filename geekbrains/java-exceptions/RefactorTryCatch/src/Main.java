public class Main {

    public static void main(String[] args) {

        int[] intArray = { 0, 1, 2, 3, 4, 5, 6, 7 };
        int index = 8;
        int d = 0;

        if (intArray == null) {
            throw new RuntimeException("Array is not instantiated or points to null reference.");
        }

        if (index > intArray.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is greater than or equal to size of array.");
        }

        if (d == 0) {
            throw new ArithmeticException("You can't divide by zero.");
        }
    }
}