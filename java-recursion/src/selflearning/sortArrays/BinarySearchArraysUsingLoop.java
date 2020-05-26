package selflearning.sortArrays;

import java.util.Arrays;

public class BinarySearchArraysUsingLoop {
	public static int binarySearch(int arr[], int key) {
		int start = 0;
		int end = arr.length - 1;
		while (true) {
			if (start > end) {
				break;
			}
			int mid = findMid(start, end);
			if (key == arr[mid]) {
				return mid;
			} else if (key > arr[mid]) {
				start = mid + 1;
			} else if (key < arr[mid]) {
				end = mid - 1;
			}
		}
		return -1;
	}

	private static int findMid(int start, int end) {
		return start + (end - start) / 2;
	}

	public static void main(String args[]) {
		int[] arr = { 4, 5, 3, 7, 9, 11, 33, 2, 55, 6 };
		Arrays.sort(arr);
		int key = 3;
		int result = binarySearch(arr, key);
		if (result == -1)
			System.out.println("Element is not found!");
		else
			System.out.println("Element is found at index: " + result);
	}
}
