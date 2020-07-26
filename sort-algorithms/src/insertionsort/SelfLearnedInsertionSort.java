package insertionsort;

import util.Sort;
import util.SortUtility;

public class SelfLearnedInsertionSort extends Sort {
	private static final int DEFAULT = Integer.MAX_VALUE;
	public static void main(String[] args) {
		boolean isReverseSort = true;
		SelfLearnedInsertionSort obj = new SelfLearnedInsertionSort();
		obj.sortManipulation(isReverseSort, SortUtility.findAllNumbers());
	}

	@Override
	public void sort(int[] numbers) {
		int[] tempArray = createTempArrayForInsertion(numbers.length);
		for(int number: numbers) {
			for(int i=0 ; i< tempArray.length ; i++) {
				int currentVal = tempArray[i];
				if(currentVal == DEFAULT) {
					tempArray[i] = number;
					break;
				}else if(number < currentVal) {
					tempArray[i] = number;
					shiftCellsToTheRight(i,currentVal,tempArray);
					break;
				}
			}
		}
		SortUtility.copyArray(tempArray, numbers);
	}

	private void shiftCellsToTheRight(int i, int currentVal , int[] tempArray) {
		for(int k = i+1 ; k < tempArray.length ; k++) {
			int existing = tempArray[k];
			tempArray[k] = currentVal;
			currentVal=existing;
		}
	}

	@Override
	public void reverseSort(int[] numbers) {

		int[] tempArray = createTempArrayForInsertion(numbers.length);
		for(int number: numbers) {
			for(int i=0 ; i< tempArray.length ; i++) {
				int currentVal = tempArray[i];
				if(currentVal == DEFAULT) {
					tempArray[i] = number;
					break;
				}else if(number > currentVal) {
					tempArray[i] = number;
					shiftCellsToTheRight(i,currentVal,tempArray);
					break;
				}
			}
		}
		SortUtility.copyArray(tempArray, numbers);
	
	}

	private int[] createTempArrayForInsertion(int length) {
		int[] tempArray = new int[length];
		for(int i=0; i < length; i++) {
			tempArray[i] = DEFAULT;
		}
		return tempArray;
	}
}
