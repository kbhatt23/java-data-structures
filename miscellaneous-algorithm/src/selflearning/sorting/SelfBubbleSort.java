package selflearning.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SelfBubbleSort {

	public static void main(String[] args) {
		int[] numbers = { 33, 22, 11, 3, 23, 4, 1, 5, 7, 9, 29, 23 };
		int reverseCount = 0;
		int end = numbers.length-1;
		while (true) {
			if(end == reverseCount) {
				break;
			}
			for (int i = 0; i < numbers.length - 1 - reverseCount; i++) {
				int current = numbers[i];
				int next = numbers[i + 1];
				if (next < current) {
					numbers[i] = next;
					numbers[i + 1] = current;
				}
			}
			reverseCount++;
		}

		String numbersSorted = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println(numbersSorted);
	}

}
