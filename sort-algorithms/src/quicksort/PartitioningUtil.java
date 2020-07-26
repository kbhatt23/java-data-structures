package quicksort;

import util.SortUtility;

public class PartitioningUtil {
	public static void main(String[] args) {
		int[] numbers = { 10, 16, 8, 12, 15, 6, 3, 9, 5 };
		int pivot = findPivotAndSwap(0, 8, numbers);
		System.out.println("pivot is "+pivot);
		SortUtility.printArray(numbers);
	}

	private static int findPivotAndSwap(int start, int end, int[] numbers) {
		int i = start;
		int j = end;
		int pivot = numbers[start];
		while (i < j) {
			do {
				i++;
			} while (numbers[i] <= pivot);

				
			 while (numbers[j] > pivot) {
				j--; 
			 }
			if (i < j) {
				SortUtility.swap(i, j, numbers);
			}
		}
		SortUtility.swap(start, j, numbers);
		return j;
	}
}
