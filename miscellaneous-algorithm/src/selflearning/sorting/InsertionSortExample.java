package selflearning.sorting;

import goldman_problems.AddItemToSortedArray;

public class InsertionSortExample {
	private static final int DEFAULT_VALUE = Integer.MIN_VALUE;
public static void main(String[] args) {
	int[] numbers = { 33, 22, 11, 3, 23, 4, 1, 5, 7, 9, 29 ,23};
	int[] sortedNumbers = new int[numbers.length];
	for(int i=0 ; i< sortedNumbers.length ; i++) {
		sortedNumbers[i] = DEFAULT_VALUE;
	}
	for(int numberToAdd : numbers) {
		AddItemToSortedArray.insertItemInSortedArray(sortedNumbers, numberToAdd);
	}
	EmployeeUtils.printNumbers(sortedNumbers);
}
}
