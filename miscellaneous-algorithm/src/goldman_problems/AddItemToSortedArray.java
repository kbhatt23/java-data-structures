package goldman_problems;

import selflearning.sorting.EmployeeUtils;

public class AddItemToSortedArray {
	private static final int DEFAULT_VALUE = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int[] numbers = new int[10];
		//setting default values
		for(int i=0 ; i< numbers.length ; i++) {
			numbers[i] = DEFAULT_VALUE;
		}
		//insertion method
		int numberToAdd=10;
		insertItemInSortedArray(numbers, numberToAdd);
		insertItemInSortedArray(numbers, 11);
		insertItemInSortedArray(numbers, 13);
		insertItemInSortedArray(numbers, 9);
		insertItemInSortedArray(numbers, 12);
		insertItemInSortedArray(numbers, 14);
		insertItemInSortedArray(numbers, 5);
		insertItemInSortedArray(numbers, 1);
		insertItemInSortedArray(numbers, 19);
		insertItemInSortedArray(numbers, 7);
		insertItemInSortedArray(numbers, 0);
		insertItemInSortedArray(numbers, 20);
		EmployeeUtils.printNumbers(numbers);
	}

	public static void insertItemInSortedArray(int[] numbers, int numberToAdd) {
		System.out.println("insertItemInSortedArray trying to add "+numberToAdd+ " in existing array ");
		EmployeeUtils.printNumbers(numbers);
		for(int i=0;i<numbers.length;i++) {
			int currnetVal = numbers[i];
			if(currnetVal != DEFAULT_VALUE) {
				if(numberToAdd < currnetVal) {
					numbers[i] = numberToAdd;
					//shift cells
					shiftArraysCells(numbers,currnetVal,i);
					break;
				}else {
					if(i == numbers.length-1) {
						break;
					}
					int nextVal = numbers[i+1];
					if(nextVal == DEFAULT_VALUE) {
						numbers[i+1] = numberToAdd;
						break;
					}
					else if(numberToAdd < nextVal) {
						numbers[i+1] = numberToAdd;
						shiftArraysCells(numbers, nextVal, i+1);
						break;
					}
				}
			}else {
				numbers[i] = numberToAdd;
				break;
			}
		}
	}

	private static void shiftArraysCells(int[] numbers, int currnetVal, int i) {
		for(int n = i+1 ; n < numbers.length;n++) {
			if(n==numbers.length-1) {
				//last iteration
				if(numbers[n] == DEFAULT_VALUE) {
					numbers[n] = currnetVal;
				}
				break;
			}
			int nextVal = numbers[n];
			numbers[n]=currnetVal;
			currnetVal=nextVal;
		}
	}
}
