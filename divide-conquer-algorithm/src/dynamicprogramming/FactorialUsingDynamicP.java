package dynamicprogramming;
//purpose is that in facorials we can not use dynamic programming
//as no subproblem is again repeated
public class FactorialUsingDynamicP {
	//could even use map in ase huge amount is there
	private static int[] memory;
	public static void main(String[] args) {
		int number =8;
		memory = new int[number+1];
		int factorialResult = calculateFactorial(number);
		
		System.out.println(factorialResult);
	}

	private static int calculateFactorial(int number) {
		if(number == 0 || number ==1) {
			return 1;
		}
		if(memory[number] != 0) {
			System.out.println("using memory");
			return memory[number];
		}
		int result = number * calculateFactorial(number-1);
		memory[number] = result;
		return result;
	}

}
