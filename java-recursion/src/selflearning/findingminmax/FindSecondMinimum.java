package selflearning.findingminmax;

public class FindSecondMinimum {
public static void main(String[] args) {
	int[] numbers = {4,5,3,7,9,11,33,2,55,6};
	FindSecondMinimum obj = new FindSecondMinimum();
	System.out.println("second smallest " +obj.findSecondMin(numbers));
}
//second min is smallest than all others but greater than smallest
private int findSecondMin(int[] numbers) {
	int smallest = numbers[0];
	int secondSmallest = numbers[1];
	for(int i =0 ; i < numbers.length ; i++) {
		int currentNumber = numbers[i];
		if(currentNumber < smallest) {
			secondSmallest = smallest;
			smallest = currentNumber;
		}
	}
	return secondSmallest;
}
}
