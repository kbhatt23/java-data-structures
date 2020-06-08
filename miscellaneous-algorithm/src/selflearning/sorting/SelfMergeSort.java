package selflearning.sorting;

import java.util.Arrays;

public class SelfMergeSort {

	public static void main(String[] args) {

		int[] numbers = { 23, 23, 99, 90, 1, 66, 101, 1008, 108, 1007 };

		mergeSort(numbers, 0, numbers.length - 1);
		//MergeSort.mergeSort(numbers, 0, numbers.length-1);
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

	private static void merge(int[] numbers, int l, int r, int m) {

		 // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int leftArray[] = new int[n1]; 
        int rightArray[] = new int[n2]; 
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) 
        	leftArray[i] = numbers[l + i]; 
        for (int j = 0; j < n2; ++j) 
        	rightArray[j] = numbers[m + 1 + j]; 


		// merge
		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) { 
				if (leftArray[i] < rightArray[j]) {
					numbers[k] = leftArray[i];
					i++;

				} else {
					numbers[k] = rightArray[j];
					j++;
				}
				k++;
			}
		
		   /* Copy remaining elements of L[] if any */
        while (i < n1) { 
        	numbers[k] = numbers[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) { 
        	numbers[k] = numbers[j]; 
            j++; 
            k++; 
        } 
		}

}
