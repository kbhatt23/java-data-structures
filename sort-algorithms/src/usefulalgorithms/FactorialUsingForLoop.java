package usefulalgorithms;

public class FactorialUsingForLoop {
public static void main(String[] args) {
	int number = 13;
	int factorialResult = 1;
	for(int i = number ; i > 0 ; i--) {
		factorialResult = factorialResult*i; 
	}
	System.out.println("factorial of number "+number + " is "+factorialResult);
}
}
