package insertionsort;

import util.Sort;
import util.SortUtility;

public class InsertionSort extends Sort {
	private static final int DEFAULT = Integer.MAX_VALUE;

	public static void main(String[] args) {
		boolean isReverseSort = false;
		InsertionSort obj = new InsertionSort();
		//obj.sortManipulation(isReverseSort, SortUtility.findAllNumbers());
		obj.sortManipulation(isReverseSort, new int[] {20,35,-15,7,55,1,22});
	}

	@Override
	public void sort(int[] numbers) {
		// sorted index
		int sortedIndex = 0;
		int unsortedIndex = 1;
		for (; unsortedIndex < numbers.length; unsortedIndex++) {
			boolean isCompleted = true;
			int calcUnsortedNumber = Integer.MAX_VALUE;
			int unCompletedUnsortedIndex= unsortedIndex;
			for (; sortedIndex >= 0; sortedIndex--) {
				int sortedNumber = numbers[sortedIndex];
				int unsortedNumber = 0;
				if(!isCompleted && calcUnsortedNumber != Integer.MAX_VALUE) {
					 unsortedNumber = calcUnsortedNumber;
				}else {
					 unsortedNumber = numbers[unsortedIndex];
				}
				if (unsortedNumber >= sortedNumber) {
					// so that coparison starts from next index
					sortedIndex++;
					break;
				} else {
					numbers[unsortedIndex] = sortedNumber;
					calcUnsortedNumber=unsortedNumber;
					isCompleted = false;
					unsortedIndex--;
				}
			}
			unsortedIndex = unCompletedUnsortedIndex;
		}
	}

	private void shiftCellsToTheRight(int i, int currentVal, int[] tempArray) {
		for (int k = i + 1; k < tempArray.length; k++) {
			int existing = tempArray[k];
			tempArray[k] = currentVal;
			currentVal = existing;
		}
	}

	@Override
	public void reverseSort(int[] numbers) {

		// not implementing as of now
	}

	private int[] createTempArrayForInsertion(int length) {
		int[] tempArray = new int[length];
		for (int i = 0; i < length; i++) {
			tempArray[i] = DEFAULT;
		}
		return tempArray;
	}
}
