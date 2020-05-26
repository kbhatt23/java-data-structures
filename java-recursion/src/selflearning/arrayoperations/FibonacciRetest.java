package selflearning.arrayoperations;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FibonacciRetest {

	public static void main(String[] args) {
		int size = 11;
		// using loop
		int[] fibonacciArray = createFibonacciArrayUsingLoop(size);
		String series = Arrays.stream(fibonacciArray).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println("using loop: "+series);
		
		int[] fibonacciArray1 = createFibonacciArrayUsingRecursion(size);
		String series1 = Arrays.stream(fibonacciArray1).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println("using recursion "+series1);
	}

	private static int[] createFibonacciArrayUsingLoop(int size) {
		int[] arr = new int[11];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < size; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr;
	}
	
	private static int[] createFibonacciArrayUsingRecursion(int size) {
		int[] arr = new int[11];
		arr[0] = 0;
		arr[1] = 1;
		seriesRecursion(arr, 2);
		return arr;
	}

	private static void seriesRecursion(int[] arr, int index) {
		if(arr.length == index) {
			return;
		}
		arr[index] = arr[index-1] + arr[index-2];
		seriesRecursion(arr, index+1);
	}
}
