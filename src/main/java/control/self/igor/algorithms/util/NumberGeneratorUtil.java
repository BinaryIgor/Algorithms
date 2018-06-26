package control.self.igor.algorithms.util;

public class NumberGeneratorUtil {

    public static int[] generateNumber(int maxLength) {
	int length = generateNumber(1, maxLength);
	int[] number = new int[length];
	for (int i = 0; i < length; i++)
	    number[i] = generateDigit();
	return number;
    }

    private static int generateDigit() {
	return generateNumber(0, 9);
    }

    public static int generateNumber(int min, int max) {
	max = min >= 0 ? max : max - min;
	return min + (int) (Math.random() * max);
    }
}
