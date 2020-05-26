package selflearning.findingminmax;

public class FindMinOfUnsortedArray {
	private int recustiveSmallest;
public static void main(String[] args) {
	int[] numbers = {7,5,4,7,9,11,33,2,55,6};
	FindMinOfUnsortedArray obj = new FindMinOfUnsortedArray();
	
	System.out.println("min using iteration "+obj.smallesUsingIteration(numbers));
	obj.recustiveSmallest = numbers[0];
	obj.smallesUsingRecursion(numbers, 1);
	System.out.println("min using recursion "+obj.recustiveSmallest);
}

//O(N complexity)
private int smallesUsingIteration(int[] numbers) {
	int smallest = numbers[0];
	for(int i =1; i < numbers.length ; i++) {
		if(numbers[i] < smallest) {
			smallest = numbers[i];
		}
	}
	return smallest;
}

private void smallesUsingRecursion(int[] numbers , int index) {
	if(numbers.length == index) {
		return;
	}
	int number = numbers[index];
	if(number < recustiveSmallest) {
		recustiveSmallest = number;
	}
	//next index;
	 smallesUsingRecursion(numbers, index+1);
}
}
