package existingalgo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SelectionSortUsingGreedy {
public static void main(String[] args) {
	int[] numbers = { 33, 22, 11, 3, 23, 4, 1, 5, 7, 9, 29 ,23};
	int[] selectionSort = insertionSort(numbers);
	String numbersSorted= Arrays.stream(selectionSort).mapToObj(String::valueOf).collect(Collectors.joining(","));
	System.out.println(numbersSorted);
}

private static int[] insertionSort(int[] numbers) {
	//find minimum number at any time and freeze it to next index of new temp array
	int[] tempArray = new int[numbers.length];
	for(int i=0 ; i<numbers.length;i++) {
		tempArray[i] = findSmallestNumber(numbers);
	}
	return tempArray;
}


private static int findSmallestNumber(int[] numbers) {
	int smallest = numbers[0];
	int smallestNumberIndex = 0 ;
	for(int i=0; i<numbers.length;i++) {
		int currnetVal = numbers[i];
		if(currnetVal < smallest) {
			smallest=currnetVal;
			smallestNumberIndex=i;
		}
	}
	//maxing out so that we win
	numbers[smallestNumberIndex] = Integer.MAX_VALUE;
	return smallest;
}
}
