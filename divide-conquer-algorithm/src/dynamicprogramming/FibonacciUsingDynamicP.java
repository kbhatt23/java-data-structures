package dynamicprogramming;

public class FibonacciUsingDynamicP {
	private static int[] memory;
	public static void main(String[] args) {
		int index = 14;
		memory = new int[index+1];
		int numberAtIndexOfSeries = findNumberAtSeries(index);
		System.out.println(numberAtIndexOfSeries);
	}

	private static int findNumberAtSeries(int index) {
		if(index == 0 || index == 1) {
			return index;
		}
		if(memory[index] != 0 ) {
			System.out.println("returing from memory");
			return memory[index];
		}
		int result =  findNumberAtSeries(index -1) + findNumberAtSeries(index-2);
		memory[index] = result;
		return result;
		
	}

}
