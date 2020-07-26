package selectionsort;

import util.Sort;

public class SelfSelectionSort extends Sort {
	public static void main(String[] args) {
		int[] numbers = { 23, 23, 99, 90, 1, 66, 101, 1008, 108, 1007 };
		boolean isReverseSort = true;
		SelfSelectionSort obj = new SelfSelectionSort();
		obj.sortManipulation(isReverseSort, numbers);
	}

	@Override
	public void sort(int[] numbers) {
		for(int i=0; i < numbers.length ; i++) {
			for(int j = i+1; j<numbers.length ; j++) {
				int current = numbers[i];
				int next = numbers[j];
				if(next < current) {
					numbers[i]= next;
					numbers[j] = current;
				}
			}
				
		}
	}

	@Override
	public void reverseSort(int[] numbers) {

		for(int i=0; i < numbers.length ; i++) {
			for(int j = i+1; j<numbers.length ; j++) {
				int current = numbers[i];
				int next = numbers[j];
				if(next > current) {
					numbers[i]= next;
					numbers[j] = current;
				}
			}
				
		}
	
	}

}
