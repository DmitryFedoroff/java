import java.util.Random;

public class Main {

	public static void main(String[] args) {

		String[] strArr = { "Text printed before exception is thrown", null, "Text will not be printed" };
		int[] array = fillArray(12);
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
