package selflearning.arrayoperations;

import java.util.Arrays;

public class ArrayBasic {
public static void main(String[] args) {
	Integer[] intObjArray = new Integer[3];
	for(Integer aObj : intObjArray) {
		System.out.println(aObj);
	}
	//autocasting happens -> calls .intValue ,ethod
	try{
	for(int a : intObjArray) {
		System.out.println(a);
	}
	}catch(Exception e) {
		
	}
	
	int[] arr = new int[4];
	arr[0]= 10;
	insertItemInArray(arr, 11, 1);
	insertItemInArray(arr, 12, 2);
	insertItemInArray(arr, 14, 3);
	insertItemInArray(arr, 14, 4);
	Arrays.stream(arr).forEach(System.out::println);
}
private static void insertItemInArray(int[] arr, int value, int index) {
	//checking with that index is permitted as array is of fixed size
	//contrlling index out of bound exception
	if(index < arr.length) {
		arr[index] = value;
	}else {
		System.out.println("This index is invalid");
	}
}
}
