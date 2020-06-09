package smallestnumber;

public class SmallestNumber {
	public static void main(String[] args) {
		int[] numbers = { 23, 32, 55, 22, 1, 3, 4, 244 };
		System.out.println("smallest number is " + smallestNumber(numbers));
	}

	private static int smallestNumber(int[] numbers) {

		if (numbers == null || numbers.length == 0) {
			return -1;
		}
		int smallest = numbers[0];
		for (int number : numbers) {
			// in for each it will start fomr first
			// in other for loop we can start with 1
			if (number < smallest) {
				smallest = number;
			}
		}
		return smallest;
	}

}
