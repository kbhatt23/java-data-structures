package mergesort;

import util.Sort;
import util.SortUtility;

public class MergeSort extends Sort {
	public static void main(String[] args) {
		//boolean isReverseSort = false;
		boolean isReverseSort = true;
		MergeSort obj = new MergeSort();
		obj.sortManipulation(isReverseSort, SortUtility.findAllNumbers());
		//obj.sortManipulation(isReverseSort, new int[] {20,35,-15,7,55,1,-22});
	}

	@Override
	public void sort(int[] numbers) {
		mergeSortRecursively(numbers, 0, numbers.length - 1);
	}

	protected void mergeSortRecursively(int[] numbers, int start, int end) {
		if (end > start) {
			int mid = (start + end) / 2;
			mergeSortRecursively(numbers, start, mid);
			mergeSortRecursively(numbers, mid + 1, end);
			merge(numbers, start, end, mid);
		}
	}

	private void merge(int[] numbers, int start, int end, int mid) {
		int sizeLeft = mid - start + 1;
		int sizeRight = end - mid;
		int[] leftArray = new int[sizeLeft];
		int[] rightArray = new int[sizeRight];
		for (int i = 0; i < sizeLeft; i++) {
			leftArray[i] = numbers[i + start];
		}
		for (int i = 0; i < sizeRight; i++) {
			rightArray[i] = numbers[mid + 1 + i];
		}
		int a = 0;
		int b = 0;
		int c = start;
		while (a < sizeLeft && b < sizeRight) {
			if (leftArray[a] <= rightArray[b]) {
				numbers[c] = leftArray[a];
				a++;
			} else {
				numbers[c] = rightArray[b];
				b++;
			}
			c++;
		}
		while (a < sizeLeft) {
			numbers[c] = leftArray[a];
			a++;
			c++;
		}
		while (b < sizeRight) {
			numbers[c] = rightArray[b];
			b++;
			c++;
		}
	}

	@Override
	public void reverseSort(int[] numbers) {

		mergeReverseSortRecursively(numbers, 0, numbers.length - 1);
	
	}

	protected void mergeReverseSortRecursively(int[] numbers, int start, int end) {
		if (end > start) {
			int mid = (start + end) / 2;
			mergeReverseSortRecursively(numbers, start, mid);
			mergeReverseSortRecursively(numbers, mid + 1, end);
			mergeReverse(numbers, start, end, mid);
		}
	}

	private void mergeReverse(int[] numbers, int start, int end, int mid) {
		int sizeLeft = mid - start + 1;
		int sizeRight = end - mid;
		int[] leftArray = new int[sizeLeft];
		int[] rightArray = new int[sizeRight];
		for (int i = 0; i < sizeLeft; i++) {
			leftArray[i] = numbers[i + start];
		}
		for (int i = 0; i < sizeRight; i++) {
			rightArray[i] = numbers[mid + 1 + i];
		}
		int a = 0;
		int b = 0;
		int c = start;
		while (a < sizeLeft && b < sizeRight) {
			if (leftArray[a] >= rightArray[b]) {
				numbers[c] = leftArray[a];
				a++;
			} else {
				numbers[c] = rightArray[b];
				b++;
			}
			c++;
		}
		while (a < sizeLeft) {
			numbers[c] = leftArray[a];
			a++;
			c++;
		}
		while (b < sizeRight) {
			numbers[c] = rightArray[b];
			b++;
			c++;
		}
	}
}
