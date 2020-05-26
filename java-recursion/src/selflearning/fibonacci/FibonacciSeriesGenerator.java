package selflearning.fibonacci;

import java.util.Arrays;

public class FibonacciSeriesGenerator {

	public static void main(String[] args) {
		FibonacciSeriesGenerator obj = new FibonacciSeriesGenerator();
		int size = 20;
		int[] fibonacciSeriesArray = obj.generateSeries(size);
		System.out.println("using for loop");
		Arrays.stream(fibonacciSeriesArray).forEach(System.out::println);
		System.out.println("using recursion");
		Arrays.stream(obj.generateSeriesUsingRecursion(size)).forEach(System.out::println);
	}

	private int[] generateSeries(int size) {
		int[] seriesArray = new int[size];
		for (int i = 0; i < size; i++) {
			// first index
			if (i == 0 || i == 1) {
				seriesArray[i] = i;
			} else {
				seriesArray[i] = seriesArray[i - 1] + seriesArray[i - 2];
			}
		}
		return seriesArray;
	}
	private int[] generateSeriesUsingRecursion(int size) {
		int[] seriesArray = new int[size];
		seriesArray[0] = 0;
		seriesArray[1] = 1;
		
		runSeries(seriesArray, size , 2);
		return seriesArray;
	}

	private void runSeries(int[] seriesArray, int size, int index) {
		if(index  == size) {
			return;
		}
		seriesArray[index] = seriesArray[index-1]+ seriesArray[index-2];
		runSeries(seriesArray, size, index+1);
	}
}
