package radixsort;

import java.util.Arrays;
import java.util.Comparator;

import util.Sort;
import util.SortUtility;

public class SelfRadixSort extends Sort{

	public static void main(String[] args){
		//width and radix shud be same
		int[] numbers = {1330,8792,1594,4725,4586,5729};
		SelfRadixSort obj = new SelfRadixSort();
		obj.sortManipulation(true, numbers);
	}

	@Override
	public void sort(int[] numbers) {
		//assuming width is same for all numbers
		int width = 0;
		int temp = 1;
		int randomNumber = numbers[0];
		while(temp <= randomNumber ) {
			temp*=10;
			width++;
		}
		int widthPosition = 10; 
		for(int k=0 ; k <width ; k++) {
			
			int iteration = 0;
			int size = numbers.length;
			// after end of every while loop largest element moves to end
			// on second end of while loop second largest goes to second last and so on
			// another check adding as once last elemnet is the greatest that and second
			// last will never be swapped
			// so second time we can do looping in for for third last element only
			while (iteration < numbers.length - 1) {
				for (int i = 0; i < size - 1; i++) {
					int current = numbers[i];
					int next = numbers[i + 1];
					int currentWidthPosition = current % widthPosition;
					int nextWidthPosition = next % widthPosition;
					if (nextWidthPosition < currentWidthPosition) {
						numbers[i] = next;
						numbers[i + 1] = current;
					}
				}
				iteration++;
				size--;
			}
			System.out.println("array aftr sorting at position " + widthPosition + ": "
			);
			SortUtility.printArray(numbers);
			widthPosition = widthPosition*10;
		}
		
	}

	@Override
	public void reverseSort(int[] numbers) {

		//assuming width is same for all numbers
		int width = 0;
		int temp = 1;
		int randomNumber = numbers[0];
		while(temp <= randomNumber ) {
			temp*=10;
			width++;
		}
		int widthPosition = 10; 
		for(int k=0 ; k <width ; k++) {
			
			int iteration = 0;
			int size = numbers.length;
			// after end of every while loop largest element moves to end
			// on second end of while loop second largest goes to second last and so on
			// another check adding as once last elemnet is the greatest that and second
			// last will never be swapped
			// so second time we can do looping in for for third last element only
			while (iteration < numbers.length - 1) {
				for (int i = 0; i < size - 1; i++) {
					int current = numbers[i];
					int next = numbers[i + 1];
					int currentWidthPosition = current % widthPosition;
					int nextWidthPosition = next % widthPosition;
					if (nextWidthPosition > currentWidthPosition) {
						numbers[i] = next;
						numbers[i + 1] = current;
					}
				}
				iteration++;
				size--;
			}
			System.out.println("array aftr sorting at position " + widthPosition + ": "
			);
			SortUtility.printArray(numbers);
			widthPosition = widthPosition*10;
		}
		
	
	}

}
