package selflearning.sortArrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		int[] array1 = { 4, 8, 13, 19 };
		int[] array2 = { 1, 2, 14, 17, 23 };
		mergeSortedArrays(array1, array2);
	}

	public static void mergeSortedArrays(int[] array1, int[] array2) {
		int totalSize = array1.length + array2.length;
		int i = 0;
		int j = 0;
		int k = 0;

		int[] mergedArray = new int[totalSize];
		while (i < array1.length && j < array2.length) {
			if (array1[i] <= array2[j]) {
				mergedArray[k] = array1[i];
				i++;
			} else {
				mergedArray[k] = array2[j];
				j++;
			}
			k++;
		}
		if (i == array1.length) {
			// meaning first array was complete
			for (; j < array2.length; j++) {
				mergedArray[k] = array2[j];
			}
		}
		else if (j == array2.length) {
			for (; i < array2.length; i++) {
				mergedArray[k] = array1[i];
			}
		}
		String finalarraystr = Arrays.stream(mergedArray).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println(finalarraystr);
	}
}
