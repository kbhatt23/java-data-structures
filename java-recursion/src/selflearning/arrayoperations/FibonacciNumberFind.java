package selflearning.arrayoperations;

public class FibonacciNumberFind {
public static void main(String[] args) {
	//considering count starts with 1
	int index = 14;
	int number = findNumberOfFibonacciSeries(index-1);
	System.out.println(number);
}

private static int findNumberOfFibonacciSeries(int i) {
	if(i == 0) {
		return 0;
	}
	if(i == 1) {
		return 1;
	}
	return findNumberOfFibonacciSeries(i-1)+findNumberOfFibonacciSeries(i-2);
}
}
