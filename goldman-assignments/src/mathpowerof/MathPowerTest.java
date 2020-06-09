package mathpowerof;

public class MathPowerTest {
public static void main(String[] args) {
	//anythins is power of 10 if 
	//eg 10 is power of as 10/10 -> 1
	//100 is power of 10 as 100/10/10
	
	int number =11;
	boolean isDivisible = isPowerOf10V1(number);
	boolean isDivisibleV2 = isPowerOf10V2(number);
	System.out.println("isDivisible for number "+number + " = "+isDivisible);
	
	System.out.println("isDivisibleV2 for number "+number + " = "+isDivisibleV2);
}

private static boolean isPowerOf10V1(double number) {
	if(number < 10) {
		return false;
	}
	boolean isDivisible = false;
	while(true) {
		number = number/10;
		if(number == 1) {
			isDivisible = true;
			break;
		}
		if(!(number % 10 == 0)) {
			break;
		}
	}
	return isDivisible;
}


private static boolean isPowerOf10V2(double number) {
	if(number < 10) {
		return false;
	}
	boolean isDivisible = false;
	while(number % 10 == 0) {
		number = number/10;
		if(number == 1) {
			isDivisible = true;
			break;
		}
	}
	return isDivisible;
}
}
