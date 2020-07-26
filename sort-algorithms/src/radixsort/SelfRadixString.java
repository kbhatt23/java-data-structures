package radixsort;

import java.util.Arrays;
import java.util.stream.Collectors;

import util.SortUtility;

public class SelfRadixString {

	public static void main(String[] args){
		//width and radix shud be same
		String[] numbers = {"bcdef","dbaqc","abcde","omadd","bbbbb"};
		SelfRadixString obj = new SelfRadixString();
		obj.sort(numbers);
		String sortedNumbers = Arrays.stream(numbers).collect(Collectors.joining(","));
		System.out.println(sortedNumbers);
	}

	public void sort(String[] numbers) {
		//assuming width is same for all numbers
		int width = numbers[0].length();
		for(int k=width-1 ; k >=0 ; k--) {
			
			int iteration = 0;
			int size = numbers.length;
			// after end of every while loop largest element moves to end
			// on second end of while loop second largest goes to second last and so on
			// another check adding as once last elemnet is the greatest that and second
			// last will never be swapped
			// so second time we can do looping in for for third last element only
			while (iteration < numbers.length - 1) {
				for (int i = 0; i < size - 1; i++) {
					String current = numbers[i];
					String next = numbers[i + 1];
					Character currentWidthPosition = current.charAt(k);
					Character nextWidthPosition = next.charAt(k);
					if (nextWidthPosition < currentWidthPosition) {
						numbers[i] = next;
						numbers[i + 1] = current;
					}
				}
				iteration++;
				size--;
			}
		}
		
	}

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
