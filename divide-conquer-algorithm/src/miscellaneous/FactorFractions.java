package miscellaneous;

//given a number find how many combinations can be made by adding and using 1,3,4
public class FactorFractions {
	public static void main(String[] args) {
		int number = 23;
		int findwaysRecursively = findwaysRecursively(number);
		System.out.println(findwaysRecursively);
	}

	private static int findwaysRecursively(int number) {
		if (number == 0 || number == 1 || number == 2) {
			// only one way -> {1} and {1,1} as 3 and 4 are greater than these numbers
			return 1;
		}
		// onl;y 2 possiblities -> {1,1,1} and {1,2} can not use 4 as it is bigger than
		// 4
		if (number == 3) {
			return 2;
		}
		return findwaysRecursively(number - 1) + findwaysRecursively(number - 3) + findwaysRecursively(number - 4);
	}
}
