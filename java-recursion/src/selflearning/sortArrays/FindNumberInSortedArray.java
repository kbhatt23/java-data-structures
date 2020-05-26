package selflearning.sortArrays;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FindNumberInSortedArray {
public static void main(String[] args) {
	int numToFind = 55;
	int[] numbers = { 4, 5, 3, 7, 9, 11, 33, 2, 6, 55 };
	LocalTime startTime = LocalTime.now();
	System.out.println(FindNumberInUnsortedArray.findNumberInAray(numbers, numToFind));
	LocalTime endTime = LocalTime.now();
	System.out.println("unsorted time taken "+ Duration.between(startTime, endTime).getNano());
	Arrays.sort(numbers);
	System.out.println("numbers array "+Arrays.stream(numbers).boxed().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
	startTime = LocalTime.now();
	//using binary searching
	System.out.println("number foound at index "+findIndexUsingLoop(numbers, numToFind));
	endTime = LocalTime.now();
	System.out.println("sorted time taken "+ Duration.between(startTime, endTime).getNano());
	
}
	public static int findIndexUsingLoop(int[] numbers, int numToFind) {
		int size = numbers.length;
		//default will become like normal unsorted loop logic
		int middleIndex = 0;
		if(size %2 ==0) {
			middleIndex = size/2;
		}else {
			middleIndex = (size+1)/2;
		}
		int middleNumber = numbers[middleIndex];
		if(numToFind == middleNumber) {
			return middleIndex;
		}else {
			if(numToFind > middleNumber) {
				for(int i =middleIndex ; i < size ; i ++) {
					if(numToFind  == numbers[i]) {
						return i;
					}
				}
			}
			//when number is less than middle number
			
			else {
				for(int i = middleIndex ; i > -1 ; i--) {
					if(numToFind == numbers[i]) {
						return i;
					}
				}
				
			}
		}
		//number not found
		return -1;
	}
	
}
