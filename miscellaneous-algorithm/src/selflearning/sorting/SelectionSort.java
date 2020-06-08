package selflearning.sorting;

import java.util.HashSet;
import java.util.Set;

public class SelectionSort {
	public static void main(String[] args) {
		// selection sort is based on finding minimim/maximum and putting in aother new
		// array

		//int[] numbers = { 33, 22, 11, 3, 23, 4, 1, 5, 7, 9, 29, 23 };
		int[] numbers = {23,23,99,90,1,66,101,1008,108,1007};
		int[] sortedArray = new int[numbers.length];
		Set<Integer> smallesIndices = new HashSet<>();

		for (int sortedIndex = 0; sortedIndex < numbers.length; sortedIndex++) {
			int smallest = numbers[0];
			int smallestIndex = 0;
			for (int i = 1; i < numbers.length; i++) {
				if(smallesIndices.contains(i)) {
					continue;
				}
				if (numbers[i] < smallest) {
					smallest = numbers[i];
					smallestIndex = i;
				}
			}
			smallesIndices.add(smallestIndex);
			sortedArray[sortedIndex] = smallest;
			numbers[smallestIndex] = Integer.MAX_VALUE;

		}
		
		EmployeeUtils.printNumbers(sortedArray);
		
	}
}
