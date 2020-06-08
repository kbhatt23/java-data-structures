package selflearning.sorting;

public class SelfMergeSort2 {

	public static void main(String[] args) {

		int[] numbers = { 23, 23, 99, 90, 1, 66, 101, 1008, 108, 1007 };

		mergeSort(numbers, 0, numbers.length - 1);
		// MergeSort.mergeSort(numbers, 0, numbers.length-1);
		EmployeeUtils.printNumbers(numbers);
	}

	private static void mergeSort(int[] numbers, int start, int end) {
		// meaning shoud have more than one item
		// start = end means only one item which need not be sorted
		// but is used in searching -> start >= end
		if (end > start) {
			int mid = (start + end) / 2;
			mergeSort(numbers, start, mid);
			mergeSort(numbers, mid + 1, end);
			merge(numbers, start, end, mid);
		}
	}

	private static void merge(int[] arr, int l, int r, int m) {

		{
			// Find sizes of two subarrays to be merged
			int n1 = m - l + 1;
			int n2 = r - m;

			/* Create temp arrays */
			int L[] = new int[n1];
			int R[] = new int[n2];

			/* Copy data to temp arrays */
			for (int i = 0; i < n1; ++i)
				L[i] = arr[l + i];
			for (int j = 0; j < n2; ++j)
				R[j] = arr[m + 1 + j];

			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays
			int i = 0, j = 0;

			// Initial index of merged subarry array
			int k = l;
			while (i < n1 && j < n2) {
				if (L[i] <= R[j]) {
					arr[k] = L[i];
					i++;
				} else {
					arr[k] = R[j];
					j++;
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1) {
				arr[k] = L[i];
				i++;
				k++;
			}

			/* Copy remaining elements of R[] if any */
			while (j < n2) {
				arr[k] = R[j];
				j++;
				k++;
			}
		}

	}
}