package selflearning.sortArrays;

import java.util.Arrays;

public class BinarySearchArrays {
	public static int binarySearch(int arr[], int first, int last, int key) {
		if (last >= first) {
			int mid =0;
			int total = first+last;
			if(total %2 ==0) {
				mid = total/2;
			}else{
				total++;
				mid=total/2;
			}
			
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] > key) {
				return binarySearch(arr, first, mid - 1, key);// search in left subarray
			} else {
				return binarySearch(arr, mid + 1, last, key);// search in right subarray
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int[] arr = { 4, 5, 3, 7, 9, 11, 33, 2, 55, 6 };
		Arrays.sort(arr);
		int key = 2;
		int last = arr.length - 1;
		int result = binarySearch(arr, 0, last, key);
		if (result == -1)
			System.out.println("Element is not found!");
		else
			System.out.println("Element is found at index: " + result);
	}
}
