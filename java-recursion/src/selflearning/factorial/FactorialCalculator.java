package selflearning.factorial;

import java.time.Duration;
import java.time.LocalTime;

public class FactorialCalculator {

	public static void main(String[] args) {
		FactorialCalculator cal = new FactorialCalculator();
		int number = 5;
		long factorial = cal.calculateFactorialUsingLoop(number);
		System.out.println("factorial of "+number+ " using loop is : "+factorial);
		
		LocalTime startTime = LocalTime.now();
		long factorial1 = cal.calculateFactorialUsingRecursion(number);
		LocalTime endTime = LocalTime.now();
		System.out.println("total time taken by recursion is "+Duration.between(startTime, endTime).getNano());
		System.out.println("factorial of "+number+ " using recursion is : "+factorial1);
	}

	//using for loop
	private  long calculateFactorialUsingLoop(int number) {
		LocalTime startTime = LocalTime.now();
		long factorail = 1;
		for(; number > 1 ; number--) {
			factorail = factorail*number;
		}
		
		LocalTime endTime = LocalTime.now();
		System.out.println("total time taken by loop is "+Duration.between(startTime, endTime).getNano());
		return factorail;
	}
	
	//using for loop
		private  long calculateFactorialUsingRecursion(long number) {
			if(number == 1 || number == 0) {
				return 1;
			}
			long factorial =number * calculateFactorialUsingRecursion(number-1);
			return factorial;
		}
}
