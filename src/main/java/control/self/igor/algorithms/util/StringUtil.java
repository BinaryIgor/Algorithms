package control.self.igor.algorithms.util;

public class StringUtil {

    public static String arrayToString(int[] numbers) {
	StringBuilder builder = new StringBuilder();
	for (int i = 0; i < numbers.length - 1; ++i) {
	    builder.append(numbers[i]).append(", ");
	}
	builder.append(numbers[numbers.length - 1]);
	return builder.toString();
    }
}
