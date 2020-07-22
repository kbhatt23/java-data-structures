package alreadyknownalgo;

public class FindFibonanciNumberDnQ {
public static void main(String[] args) {
	int index = 17;
	//as like arrays lets start the index by 0
	int numberFound =findFibonacciNumber(index);
	System.out.println(numberFound);
}

private static int findFibonacciNumber(int index) {
	if(index == 0 || index == 1) {
		return index;
	}
	return findFibonacciNumber(index-1)+findFibonacciNumber(index-2);
}
}
