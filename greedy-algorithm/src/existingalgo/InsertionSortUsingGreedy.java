package existingalgo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSortUsingGreedy {
	private static final int DEFAULT_VAL = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[] numbers = { 33, 22, 11, 3, 23, 4, 1, 5, 7, 9, 29 ,23};
		int[] selectionSort = selectionSort(numbers);
		String numbersSorted= Arrays.stream(selectionSort).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println(numbersSorted);
	}
	private static int[] selectionSort(int[] numbers) {
		int[] tempArray = populateTempArray(numbers);
		for(int i=0; i< numbers.length; i++) {
			int valueToInsert = numbers[i];
			for(int j=0 ; j< tempArray.length ; j++) {
				int existingVal = tempArray[j];
				if(existingVal != DEFAULT_VAL) {
					if(valueToInsert < existingVal) {
						tempArray[j] = valueToInsert;
						shiftArrayCellstoRight(tempArray, existingVal, j);
						break;
					}
				}else {
					tempArray[j] = valueToInsert;
					break;
				}
			}
		}
		return tempArray;
	}
	private static int[] populateTempArray(int[] numbers) {
		int[] tempArray = new int[numbers.length];
		for(int i=0 ;i < tempArray.length; i++) {
			tempArray[i] = DEFAULT_VAL;
		}
		return tempArray;
	}
	
	private static void shiftArrayCellstoRight(int[] numbers, int value , int index) {
		for(int i= index+1; i < numbers.length; i++ ) {
			int existingValue = numbers[i];
			numbers[i] = value;
			value = existingValue;
		}
	}

}
