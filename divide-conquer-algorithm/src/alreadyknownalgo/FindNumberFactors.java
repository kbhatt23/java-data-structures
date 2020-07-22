package alreadyknownalgo;

import java.util.ArrayList;
import java.util.List;

public class FindNumberFactors {

	public static void main(String[] args) {
		int number=32;
		List<Integer> factors = new ArrayList<Integer>();
		//need to check number dividing this apart from itself and 1
		for(int i=2; i < number; i++ ) {
			while(number %i == 0 ) {
				factors.add(i);
				number = number/i;
			}
		}
		factors.stream().forEach(System.out::println);
	}
}
