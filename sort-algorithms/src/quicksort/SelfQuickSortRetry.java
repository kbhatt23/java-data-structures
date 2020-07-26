package quicksort;

import util.Sort;
import util.SortUtility;

public class SelfQuickSortRetry extends Sort {
	public static void main(String[] args) {
		boolean isReverseSort = false;
		SelfQuickSortRetry obj = new SelfQuickSortRetry();
		obj.sortManipulation(isReverseSort, new int[] { 10, 16, 8, 12, 15, 6, 3, 9, 5 });
	}

	@Override
	public void sort(int[] numbers) {
		quickSortRecursively(numbers, 0, numbers.length - 1);
	}

	private void quickSortRecursively(int[] numbers, int start, int end) {
		if (end > start) {
			int pivotIndex = partition(numbers, start, end);
			quickSortRecursively(numbers, start, pivotIndex);
			quickSortRecursively(numbers, pivotIndex + 1, end);
		}
	}

	private int partition(int[] numbers, int start, int end) {
		int pivot = numbers[start];
		int i = start;
		int j = end;
		while (j > i) {
			do {
				i++;
			} while (numbers[i] <= pivot);

			while (numbers[j] > pivot) {
				j--;
			}
			if (j > i) {
				SortUtility.swap(i, j, numbers);
			}
		}
		SortUtility.swap(start, j, numbers);
		return j;
	}

	@Override
	public void reverseSort(int[] numbers) {
		// ignore as of now
	}

}
