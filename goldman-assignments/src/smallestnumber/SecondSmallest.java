package smallestnumber;

public class SecondSmallest {
	public static void main(String[] args) {
		int[] numbers = { 23, 32, 55, 22, 1, 3, 4, 244 };
		System.out.println("second smallest number is " + smallestNumber(numbers));
	}

	private static int smallestNumber(int[] numbers) {

		if (numbers == null || numbers.length == 0) {
			return -1;
		}
		int smallest = numbers[0];
		int secondSmallest = numbers[1];
		for (int i=0; i <numbers.length ; i++) {
			int currentNumber = numbers[i];
			if(currentNumber < smallest) {
				secondSmallest = smallest;
				smallest = currentNumber;
			}else if(currentNumber < secondSmallest && currentNumber > smallest) {
				secondSmallest=currentNumber;
			}
		}
		return secondSmallest;
	}

}
