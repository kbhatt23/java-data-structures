package quicksort;

import util.Sort;
import util.SortUtility;

public class SelfQuickSort extends Sort {
	public static void main(String[] args) {
		boolean isReverseSort = false;
		SelfQuickSort obj = new SelfQuickSort();
		obj.sortManipulation(isReverseSort, new int[] { 10, 16, 8, 12, 15, 6, 3, 9, 5 });
	}

	@Override
	public void sort(int[] numbers) {
		quickSortRecursively(numbers, 0, numbers.length - 1);
	}

	private void quickSortRecursively(int[] numbers, int start, int end) {
		if (end > start) {
			int pivot = parition(start, end, numbers);
			System.out.println("pivot is " + pivot);
			quickSortRecursively(numbers, start, pivot);
			quickSortRecursively(numbers, pivot + 1, end);
		}
	}

	private int parition(int start, int end, int[] numbers) {

		int i = start;
		int j = end;
		int pivot = numbers[start];
		while (i < j) {
			do {
				i++;
			} while ( i < numbers.length && numbers[i] <= pivot);

				
			 while ( j >=0 && numbers[j] > pivot) {
				j--; 
			 }
			if (i < j) {
				SortUtility.swap(i, j, numbers);
			}
		}
		SortUtility.swap(start, j, numbers);
		return j;
	
	}

	@Override
	public void reverseSort(int[] numbers) {
		// skipping it as of now
	}

}
