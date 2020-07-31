package searchalgo;

import mergesort.MergeSort;
import util.SortUtility;

public class BinarySearchAlgoUsingLoop {
public static void main(String[] args) {
	int[] numbers = SortUtility.findAllNumbers();
	MergeSort mergeSort = new MergeSort();
	mergeSort.sortManipulation(false, numbers);
	System.out.println(binarySearch(numbers, 0, numbers.length-1, 91));
}
private static int binarySearch(int[] numbers, int start , int end , int numberToFind) {
	while(end >= start) {
		int mid = (start+end)/2;
		if(numbers[mid] == numberToFind) {
			return mid;
		}
		if(numberToFind < numbers[mid]) {
			end = mid-1;
		}else{
			start = mid+1;
		}
	}
	return -1;
}
}
