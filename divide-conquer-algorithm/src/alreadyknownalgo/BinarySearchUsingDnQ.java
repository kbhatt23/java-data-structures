package alreadyknownalgo;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class BinarySearchUsingDnQ {

	public static void main(String[] args) {
		int[] numbers = fetchNumbers(14, 2, 50);
		Arrays.sort(numbers);
		int numberToSearch = 23;
		int indexFound = binarySearchRecursively(numbers, numberToSearch, 0, numbers.length - 1);
		System.out.println("indexFound " + indexFound + " for number " + numberToSearch + " in array "
				+ Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.joining(",")));
	}

	private static int[] fetchNumbers(int size, int lowBound, int highBound) {
		return new Random().ints(size, lowBound, highBound).toArray();
	}

	private static int binarySearchRecursively(int[] numbers, int numberToSearch, int start, int end) {
		// breaking till only one element is left
		// in that case start and end will be same index and so will be value
		if (end >= start) {
			int mid = (start + end) / 2;
			if (numberToSearch == numbers[mid]) {
				return mid;
			}
			if (numberToSearch < numbers[mid]) {
				return binarySearchRecursively(numbers, numberToSearch, 0, mid - 1); // need to do mid-1 as mid index is
																						// already checked
			}
			if (numberToSearch > numbers[mid]) {
				return binarySearchRecursively(numbers, numberToSearch, mid + 1, end);// need to do mid+1 as mid is
																						// already checked in line 33
			}
		}
		// item not found
		return -1;
	}
}