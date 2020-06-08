package selflearning.sorting;

public class SelfLearnedSorting {
public static void main(String[] args) {
	//int[] numbers = {33,22,11,3,23,4,1,5,7,9,29,23};
	int[] numbers = {23,23,99,90,1,66,101,1008,108,1007};
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
	EmployeeUtils.printNumbers(numbers);
	System.out.println(Math.ceil(3.8));
}
}
