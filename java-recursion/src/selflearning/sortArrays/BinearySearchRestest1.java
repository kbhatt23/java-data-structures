package selflearning.sortArrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinearySearchRestest1 {
public static void main(String[] args) {
	int[] arr = { 4, 5, 3, 7, 9, 11, 33, 2, 55, 6 };
	Arrays.sort(arr);
	String arrayItems = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(","));
	System.out.println("Array items "+arrayItems);
	int number = 3;
	System.out.println("searched index "+binarySerach(arr,number, 0, arr.length-1));
}

public static int binarySerach(int[] arr, int number,int start , int end) {
	System.out.println("current iteration indices "+start + " to "+end);
	if(end >= start) {
		int midIndex = findMidIndex(start,end);
		int midValue = arr[midIndex];
		System.out.println("mid value found "+midValue);
		if(number == midValue) {
			return midIndex;
		}
		if(number > midValue) {
			return binarySerach(arr, number, midIndex+1, end);
		}else{
			return binarySerach(arr, number, start, midIndex-1);
		}
		
	}
	System.out.println("number not found");
	//default value 
	return -1;
}

private static int findMidIndex(int start, int end) {
	int total = start+end;
	if(total%2 == 0) return total/2; 
	else return (total+1)/2;
}
}
