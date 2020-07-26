package bubblesort;

import util.Sort;

public class SelfBubbleSort extends Sort {
	public static void main(String[] args) {
		int[] numbers = { 23, 23, 99, 90, 1, 66, 101, 1008, 108, 1007 };
		boolean isReverseSort = false;
		SelfBubbleSort obj = new SelfBubbleSort();
		obj.sortManipulation(isReverseSort, numbers);
	}

	@Override
	public void sort(int[] numbers) {

		int iteration = 0;
		int size = numbers.length;
		System.out.println("total size " + numbers.length);
		// after end of every while loop largest element moves to end
		// on second end of while loop second largest goes to second last and so on
		// another check adding as once last elemnet is the greatest that and second
		// last will never be swapped
		// so second time we can do looping in for for third last element only
		while (iteration < numbers.length - 1) {
			System.out.println("starting while loop");
			for (int i = 0; i < size - 1; i++) {
				System.out.println("jai shree ram");
				int current = numbers[i];
				int next = numbers[i + 1];
				if (next < current) {
					numbers[i] = next;
					numbers[i + 1] = current;
				}
			}
			iteration++;
			size--;
		}

	}

	@Override
	public void reverseSort(int[] numbers) {

		int iteration = 0;
		int size = numbers.length;
		// after end of every while loop largest element moves to end
		// on second end of while loop second largest goes to second last and so on
		while (iteration < size - 1) {
			for (int i = 0; i < numbers.length - 1; i++) {
				int current = numbers[i];
				int next = numbers[i + 1];
				if (next > current) {
					numbers[i] = next;
					numbers[i + 1] = current;
				}
			}
			iteration++;
		}

	}
}
