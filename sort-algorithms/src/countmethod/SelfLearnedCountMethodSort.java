package countmethod;

import util.Sort;
import util.SortUtility;

public class SelfLearnedCountMethodSort extends Sort{
public static void main(String[] args) {
	boolean isReverseSort = false;
	SelfLearnedCountMethodSort obj = new SelfLearnedCountMethodSort();
	obj.sortManipulation(isReverseSort, SortUtility.findAllDistributedNumbers());
}

@Override
public void sort(int[] numbers) {
	int max = SortUtility.findMaxNumber(numbers);
	int min = SortUtility.findMinNumber(numbers);
	int[] tempArray = new int[max-min+1];
	for(int i=0; i< numbers.length; i++) {
		int number = numbers[i];
		int tempArrayIndex = number-min;
		int existingCount = tempArray[tempArrayIndex];
		tempArray[tempArrayIndex] = existingCount+1;
	}
	int mainArrayIndex = 0;
	for(int i=0; i< tempArray.length; i++) {
		int numberCount = tempArray[i];
		if(numberCount == 0) {
			continue;
		}
		int numberToInsert = i+min;
		for(int startIndex = 0 ; startIndex < numberCount ; startIndex++) {
			numbers[mainArrayIndex] = numberToInsert;
			mainArrayIndex++;
		}
		
	}
}

@Override
public void reverseSort(int[] numbers) {

	int max = SortUtility.findMaxNumber(numbers);
	int min = SortUtility.findMinNumber(numbers);
	int[] tempArray = new int[max-min+1];
	for(int i=0; i< numbers.length; i++) {
		int number = numbers[i];
		int tempArrayIndex = number-min;
		int existingCount = tempArray[tempArrayIndex];
		tempArray[tempArrayIndex] = existingCount+1;
	}
	int mainArrayIndex = 0;
	for(int i=tempArray.length-1; i>=0; i--) {
		int numberCount = tempArray[i];
		if(numberCount == 0) {
			continue;
		}
		int numberToInsert = i+min;
		for(int startIndex = 0 ; startIndex < numberCount ; startIndex++) {
			numbers[mainArrayIndex] = numberToInsert;
			mainArrayIndex++;
		}
		
	}

}
}
