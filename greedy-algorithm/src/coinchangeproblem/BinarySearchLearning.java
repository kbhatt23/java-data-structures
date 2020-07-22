package coinchangeproblem;

import java.util.Arrays;

public class BinarySearchLearning {

	public static int binarySearch(int[] numbers, int numberToFind) {
		// first needs to sorts
		Arrays.sort(numbers);
		return binarySearchRecusrsively(numbers, 0, numbers.length - 1, numberToFind);
	}

	private static int binarySearchRecusrsively(int[] numbers, int start, int end, int numberToFind) {
		if (end >= start) {
			int mid = (start + end) / 2;
			if (numbers[mid] == numberToFind) {
				return mid;
			}
			if (numbers[mid] > numberToFind) {
				return binarySearchRecusrsively(numbers, start, mid, numberToFind);
			} else {
				return binarySearchRecusrsively(numbers, mid + 1, end, numberToFind);
			}
		}
		// not found at all
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { 1, 2, 5, 20, 50, 100, 500, 1000 }, 9));
	}
}
