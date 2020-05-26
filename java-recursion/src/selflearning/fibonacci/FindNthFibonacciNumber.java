package selflearning.fibonacci;

public class FindNthFibonacciNumber {
public static void main(String[] args) {
	int position = 11;
	FindNthFibonacciNumber obj = new FindNthFibonacciNumber();
	System.out.println(obj.fibonacciPosition(position));
}

	public int fibonacciPosition(int index) {
		if(index == 1) {
			return 0;
		}
		if(index  == 2) {
			return 1;
		}
		return fibonacciPosition(index-1) + fibonacciPosition(index-2);
	}
	
}
