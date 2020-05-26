package selflearning.sortArrays;

public class FindNumberInUnsortedArray {
	public static void main(String[] args) {
		int[] numbers = { 4, 5, 3, 7, 9, 11, 33, 2, 55, 6 };
		int numToFind = 33;
		int index = findNumberInAray(numbers, numToFind);
		System.out.println("using loop " + index);
		System.out.println("using recursion " + findNumberInAray(numbers, numToFind, 0));
	}

	public static int findNumberInAray(int[] numbers, int findNum) {
		for (int i = 0; i < numbers.length; i++) {
			if (findNum == numbers[i]) {
				return i;
			}
		}
		// number do not existin in array
		return -1;
	}

	private static int findNumberInAray(int[] numbers, int findNum, int index) {
		if (numbers.length == index) {
			return -1;
		}
		if (numbers[index] == findNum) {
			return index;
		}

		return findNumberInAray(numbers, findNum, index+1);
	}

}
