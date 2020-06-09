package checkprimenumber;

import java.time.Duration;
import java.time.LocalTime;

public class CheckPrimeNumber {
public static void main(String[] args) {
	int number = 96;
	
	boolean isPrime = checkPrimeNumber(number);
	System.out.println("isPrime for number is "+isPrime);
	System.out.println("isPrime for number is "+checkPrimeNumberPerformace(number));
}

private static boolean checkPrimeNumber(int number) {
	LocalTime start = LocalTime.now();
	boolean isPrime = true;
	for(int i =2 ; i < number ; i++) {
		if(number % i == 0) {
			isPrime=false;
			break;
		}
	}
	LocalTime end = LocalTime.now();
	System.out.println("checkPrimeNumber: total time taken "+Duration.between(start, end).getNano());
	return isPrime;
}
private static boolean checkPrimeNumberPerformace(int number) {
	LocalTime start = LocalTime.now();
	boolean isPrime = true;
	int half = number/2;
	for(int i =2 ; i < half+1 ; i++) {
		if(number % i == 0) {
			isPrime=false;
			break;
		}
	}
	LocalTime end = LocalTime.now();
	System.out.println("checkPrimeNumberPerformace: total time taken "+Duration.between(start, end).getNano());
	return isPrime;
}

}
