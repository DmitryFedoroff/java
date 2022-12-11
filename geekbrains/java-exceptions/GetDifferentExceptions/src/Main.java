import java.util.Random;

public class Main {

	public static void main(String[] args) {

		String[] strArr = { "Text printed before exception is thrown", null, "Text will not be printed" };
		int[] array = fillArray(12);
		divideNums(10, 0);
	}

	public static void divideNums(double firstNum, double secondNum) {

		if (secondNum == 0) {
			throw new ArithmeticException("You can't divide by zero.");
		}
		double result = firstNum / secondNum;
		System.out.printf("Division result %f by %f is equal to %f.\n", firstNum, secondNum, result);
	}

	public static void findElemIndex(int[] arr, int index) {

		if (index > arr.length - 1) {
			throw new ArrayIndexOutOfBoundsException("Element with index " + index + " is missing.");
		} else {
			System.out.printf("Element with index %d is equal to %d.\n", index, arr[index]);
		}
	}

	public static int[] fillArray(int len) {

		int[] array = new int[len];
		Random rand = new Random();

		for (int i = 0; i < len; i++) {
			array[i] = rand.nextInt(1, 10);
		}
		return array;
	}
}
