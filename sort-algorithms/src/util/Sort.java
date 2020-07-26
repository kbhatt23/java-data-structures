package util;

public abstract class Sort {

	public abstract void sort(int[] numbers);

	public abstract void reverseSort(int[] numbers);

	public void sortManipulation(boolean isReverseSort, int[] numbers) {
		if (isReverseSort) {
			reverseSort(numbers);
		} else {
			sort(numbers);
		}
		SortUtility.printArray(numbers);
	}
}
