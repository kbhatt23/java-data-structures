package selflearning.arrayoperations;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindingItemInTwoDimensionalArray {
public static void main(String[] args) {
	//inner array not instantiated
	int[][] twodArray = new int[3][];
	printArrayItems(twodArray);
	//creating array manually
	populateArrayItems(twodArray);
	printArrayItems(twodArray);
	int numToFind=11;
	int[] indexedSearch = searchTwodArray(twodArray, numToFind);
	String indexes = Arrays.stream(indexedSearch).mapToObj(String::valueOf).collect(Collectors.joining(","));
	System.out.println("index found "+indexes);
}

private static int[] searchTwodArray(int[][] twodArray, int numToFind) {
	//case when no entry were found
	int[] index = {-1,-1};
	outer: for(int i =0; i< twodArray.length; i++) {
		int[] innerArray = twodArray[i];
		 for(int j=0; j < innerArray.length; j++) {
			if(numToFind == twodArray[i][j]) {
				index[0] = i;
				index[1] = j;
				//it helps to break outer loop and hence firs entry found will be returned
				break outer;
			}
		}
	}
	return index;
}

private static void populateArrayItems(int[][] twodArray) {
	for(int i=0; i< twodArray.length ; i++) {
		twodArray[i] = new int[4];
		for(int j= 0; j<twodArray[i].length ; j++) {
			twodArray[i][j] = 11;
		}
	}
}

private static void printArrayItems(int[][] twodArray) {
	System.out.println("starting printing of array");
	for(int i = 0 ; i< twodArray.length ; i++) {
		int[] innerArray = twodArray[i];
		if(innerArray != null) {
		//need to have null check
		for(int j =0 ; j < innerArray.length ; j++) {
			System.out.println("item: "+twodArray[i][j]);
		}
		}
	}
}
}
