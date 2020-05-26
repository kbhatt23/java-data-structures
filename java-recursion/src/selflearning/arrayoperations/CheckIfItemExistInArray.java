package selflearning.arrayoperations;

import java.util.Arrays;

public class CheckIfItemExistInArray {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 3, 7, 9, 11, 33, 2, 55, 6 };
		Arrays.sort(arr);
		int numTocheck =55;
		boolean isExistUsingStream = checkUsingStreams(arr, numTocheck);
		System.out.println("isExistUsingStream: "+isExistUsingStream);
		
		boolean isExistUsingLoop = checkUsingLoop(arr, numTocheck);
		System.out.println("isExistUsingLoop "+isExistUsingLoop);
		
		//needs sorting :hence sorting at the begining itself
		boolean isExistUsingBinarySeatch = checkUsingBinarySearch(arr, numTocheck ,0 ,arr.length-1);
		System.out.println("isExistUsingBinarySeatch "+isExistUsingBinarySeatch);
	}

	private static boolean checkUsingBinarySearch(int[] arr, int numTocheck, int start, int end) {
		if(end >= start) {
			int mid = calculateMid(start, end);
			if(arr[mid] == numTocheck) {
				return true;
			}else {
				if(numTocheck > arr[mid]) {
					return checkUsingBinarySearch(arr, numTocheck, mid+1, end);
				}else {
					return checkUsingBinarySearch(arr, numTocheck, start, mid-1);
				}
			}
		}
		//terminating the loop
		return false;
	}
	private static int calculateMid(int start, int end) {
		return (start+end)/2;
	}

	private static boolean checkUsingLoop(int[] arr, int numTocheck) {
		boolean isExist = false;
		for(int i=0 ; i <arr.length; i++) {
			if(numTocheck == arr[i]) {
				isExist = true;
			}
		}
		return isExist;
	}

	private static boolean checkUsingStreams(int[] arr, int numTocheck) {
		return Arrays.stream(arr)
			  .anyMatch(i -> i ==numTocheck);	
	}
}
