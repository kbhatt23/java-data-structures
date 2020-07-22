package alreadyknownalgo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSortUsingDnQ {

	public static void main(String[] args) {
		int[] numbers = { 23, 23, 99, 90, 1, 66, 101, 1008, 108, 1007 };
		mergeSortRecursively(numbers, 0, numbers.length-1);
		String numbersSorted= Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println(numbersSorted);
	}
	
	private static void mergeSortRecursively(int[] numbers,int start, int end) {
		//keep on dividing until 2 items are there 
		//in binary search we didivide until one one element is found -> end>=start
		if(end > start) {
			int mid = (start+end)/2;
			//no need of condition as we need to sort both left and right always
			mergeSortRecursively(numbers, start, mid); // we are including mid index as wll unlike binary search where we did mid-1
			mergeSortRecursively(numbers, mid+1, end);
			merge(numbers,start,end,mid);
		}
	}

	private static void merge(int[] numbers, int start, int end, int mid) {
		
		int firstArraySize = mid-start+1;int[] firstArray = new int[firstArraySize];
		int secondArraySize = end-mid;int[] secondArray = new int[secondArraySize];
		for(int i=0 ; i<firstArraySize ; i++) {
			firstArray[i] = numbers[start+i];
		}
		for(int i=0 ; i<secondArraySize ; i++) {
			secondArray[i] = numbers[mid+i+1];
		}
		
		int i=0; int j=0; int k=start;
		while(i < firstArraySize && j< secondArraySize) {
			//<= as item already present on left should be first added on the left of whole array
			if(firstArray[i] <= secondArray[j]) {
				numbers[k] = firstArray[i];
				i++;
			}else {
				numbers[k] = secondArray[j];
				j++;
			}
			k++;
		}
		while(i < firstArraySize) {
			//add remaining items from first array
			numbers[k] = firstArray[i];
			i++;k++;
		}
		while(j < secondArraySize) {
			//add remaining items from first array
			numbers[k] = secondArray[j];
			j++;k++;
		}
	}

}
