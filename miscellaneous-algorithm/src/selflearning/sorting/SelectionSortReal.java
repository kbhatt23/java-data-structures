package selflearning.sorting;

public class SelectionSortReal {
	public static void main(String[] args) {
		// selection sort is based on finding minimim/maximum and putting in aother new
		// array

		// int[] numbers = { 33, 22, 11, 3, 23, 4, 1, 5, 7, 9, 29, 23 };
		int[] numbers = { 23, 23, 99, 90, 1, 66, 101, 1008, 108, 1007 };
		for (int sortedIndex = 0; sortedIndex < numbers.length; sortedIndex++) {
			int smallest = numbers[sortedIndex];
			int smallestIndex = sortedIndex;
			for (int i = sortedIndex + 1; i < numbers.length; i++) {
				if (numbers[i] < smallest) {
					smallest = numbers[i];
					smallestIndex = i;
				}
			}
			int current = numbers[sortedIndex];
			numbers[smallestIndex] = current;
			numbers[sortedIndex] = smallest;

		}

		EmployeeUtils.printNumbers(numbers);

	}
}
