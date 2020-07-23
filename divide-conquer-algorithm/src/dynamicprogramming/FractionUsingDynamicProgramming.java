package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FractionUsingDynamicProgramming {
	// better to use map
	// private static int[] memory;
	private static Map<Integer, Integer> memory = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		int number = 11;
		System.out.println(calculateFractions(number));
		System.out.println(calculateFractionsUsingBottomUp(number));
	}

	private static int calculateFractions(int number) {
		// can be created using 1,3 and 4
		if (number == 0 || number == 1 || number == 2) {
			return 1;
		}
		if (number == 3) {
			return 2;
		}
		if (memory.containsKey(number)) {
			Integer integer = memory.get(number);
			System.out.println("fetching content from memory for number " + number + " with value " + integer);
			return integer;
		}
		// to[ down first calculating bigger problem
		int result = calculateFractions(number - 4) + calculateFractions(number - 3) + calculateFractions(number - 1);
		memory.put(number, result);
		return result;
	}

	// faster as no need of method stack
	private static int calculateFractionsUsingBottomUp(int number) {
		// can be created using 1,3 and 4
		int[] totalData = new int[number + 1];
		totalData[0] = totalData[1] = totalData[2] = 1;
		totalData[3] = 2;

		for (int i = 4; i < totalData.length; i++) {
			totalData[i] = totalData[i - 1] + totalData[i - 3] + totalData[i - 4];
		}
		return totalData[number];
	}

}
