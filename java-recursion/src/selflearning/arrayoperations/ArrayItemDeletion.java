package selflearning.arrayoperations;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayItemDeletion {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 3, 7, 9, 11, 33, 2, 55, 6 };
		int numberToRemove = 3;
		
		int[] newArray = removeITemFromArray(arr,numberToRemove);
		String finalArr= Arrays.stream(newArray).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(","));
		System.out.println(finalArr);
	}

	private static int[] removeITemFromArray(int[] arr, int numberToRemove) {
		//get the index
		int index = findIndexOfItem(arr, numberToRemove);
		if(index == -1) {
			throw new RuntimeException("Please enter valid number to rmeove");
		}
		//valid removal
		int[] newArray = new int[arr.length-1];
		for(int i =0 ; i < newArray.length ; i++) {
			if(i < index) {
				newArray[i] = arr[i];
			}else {
				newArray[i] = arr[i+1];
			}
		}
		return newArray;
	}

	private static int findIndexOfItem(int[] arr, int numberToRemove) {
		int index = -1;
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] == numberToRemove) {
				index = i;
			}
		}
		return index;
	}
}
