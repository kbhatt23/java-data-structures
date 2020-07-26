package usefulalgorithms;

public class FacotrialUsingRecursion {
public static void main(String[] args) {
	int number = 13;
	int factorialResult = calcualteFactorialRecursively(number);
	System.out.println("factorial of number "+number + " is "+factorialResult);
}

private static int calcualteFactorialRecursively(int number) {
	if(number == 0 || number == 1) {
		return 1;
	}
	return number * calcualteFactorialRecursively(number-1);
}
}
