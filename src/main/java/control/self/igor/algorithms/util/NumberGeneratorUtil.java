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
	if (min > max) {
	    int tmp = min;
	    min = max;
	    max = tmp;
	}
	int range = (int) Math.round((Math.random() * (max - min)));
	return min + range;
    }
}
