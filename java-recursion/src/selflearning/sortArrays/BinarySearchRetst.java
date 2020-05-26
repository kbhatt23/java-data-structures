package selflearning.sortArrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinarySearchRetst {
public static void main(String[] args) {
	int numToFind =33;
	int[] numbers = { 4, 5, 3, 7, 9, 11, 33, 2, 6, 55 };
	Arrays.sort(numbers);
	System.out.println("numbers array "+Arrays.stream(numbers).boxed().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
	System.out.println("index of number found at "+binarySearch(numbers, numToFind, 0, numbers.length-1));
}

private static int binarySearch(int[] numbers, int numToFind, int start, int end) {
	if(end >=start) {
		int mid = calculateMid(start, end);
		if(numbers[mid] == numToFind) {
			return mid;
		}else if(numToFind > numbers[mid]) {
			return binarySearch(numbers, numToFind, mid+1, end);
		}else if(numToFind < numbers[mid]) {
			return binarySearch(numbers, numToFind, start, mid-1);
		}
	}
	//item donot exist
	return -1;
}
private static int calculateMid(int start , int end) {
	int total =start+end;
	if(total %2 == 0) {
		return total/2;
	}else {
		return (total+1)/2;
	}
}
}
