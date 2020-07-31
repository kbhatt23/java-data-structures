package searchalgo;

import mergesort.MergeSort;
import util.SortUtility;

public class BinarySearchAlgo {
public static void main(String[] args) {
	int[] numbers = SortUtility.findAllNumbers();
	MergeSort mergeSort = new MergeSort();
	mergeSort.sortManipulation(false, numbers);
	System.out.println(binarySearch(numbers, 0, numbers.length-1, 23));
}
private static int binarySearch(int[] numbers, int start , int end , int numberToFind) {
	//breaking until only one element is left
	//but items should be sorted
	if(end >= start) {
		int mid = (start + end)/2 ;
		if(numberToFind == numbers[mid]) {
			return mid;
		}
		if(numberToFind < numbers[mid] ) {
			return binarySearch(numbers, 0, mid-1, numberToFind);
		}
		else {
			return binarySearch(numbers, mid+1, end, numberToFind);
		}
	}
	return -1;
}
}
