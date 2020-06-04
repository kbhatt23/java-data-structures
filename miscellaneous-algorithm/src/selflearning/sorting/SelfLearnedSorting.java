package selflearning.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SelfLearnedSorting {
public static void main(String[] args) {
	int[] numbers = {33,22,11,3,23,4,1,5,7,9,29};
	
	for(int i =0 ; i< numbers.length ; i++) {
		for(int j= i+1 ; j < numbers.length ; j++) {
			int current = numbers[i];
			int next = numbers[j];
			if(next < current) {
				numbers[i]=next;
				numbers[j]= current;
			}
		}
	}
	String numbersSorted= Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(","));
	System.out.println(numbersSorted);
}
}
