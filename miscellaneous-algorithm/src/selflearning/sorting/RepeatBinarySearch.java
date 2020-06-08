package selflearning.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RepeatBinarySearch {

	public static void main(String[] args) {
		int[] numbers = { 23, 23, 99, 90, 1, 66, 101, 1008, 108, 1007 };
		Arrays.sort(numbers);
		String arryPrint = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println("array data " + arryPrint);
		int number = 1008;

		int foundIndex = binarySearch(numbers, number, 0, numbers.length - 1);
		System.out.println(foundIndex);
		
		for(int i =0 ;i< numbers.length ; i++) {
			int index = binarySearch(numbers, numbers[i], 0, numbers.length-1);
			System.out.println("number searched "+numbers[i] + " found number "+numbers[index]);
		}

	}

	private static int binarySearch(int[] numbers, int number, int start, int end) {
		if (end >= start) {
			int total = start + end;
			int mid = 0;
			if (total % 2 == 0)
				mid = total / 2;
			else
				mid = (total + 1) / 2;
			if (number == numbers[mid]) {
				return mid;
			}
			if (number > numbers[mid]) {
				return binarySearch(numbers, number, mid + 1, end);
			}
			if (number < numbers[mid]) {
				return binarySearch(numbers, number, start, mid - 1);
			}

		}
		System.out.println("number not found");
		return -1;
	}
}
