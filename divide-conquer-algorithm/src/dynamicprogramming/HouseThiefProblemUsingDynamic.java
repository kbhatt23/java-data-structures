package dynamicprogramming;

//thief can pick only adjacent houses
//we need to max out the theft collection
public class HouseThiefProblemUsingDynamic {
	private static int[] memory;

	public static void main(String[] args) {
		//int[] houses = new int[] { 6, 7, 1, 30, 8, 2, 4 };
		int[] houses = new int[] {20,5,1,13,6,11,40};
		memory = new int[houses.length + 1];
		int totalCollectionMax = calculateMAxCollection(0, houses);
		System.out.println(totalCollectionMax);
	}

	private static int calculateMAxCollection(int index, int[] houses) {
		if (index >= houses.length) {
			System.out.println("end reached");
			return 0;
		}
		if (memory[index] != 0) {
			System.out.println("using exisitng memory with index " + index + " and value " + memory[index]);
			return memory[index];
		}
		int collectionUsingCurrent = houses[index] + calculateMAxCollection(index + 2, houses);
		int collectionAfterSkippingCurrnet = calculateMAxCollection(index + 1, houses);
		int result = Math.max(collectionUsingCurrent, collectionAfterSkippingCurrnet);
		memory[index] = result;
		return result;
	}
}
