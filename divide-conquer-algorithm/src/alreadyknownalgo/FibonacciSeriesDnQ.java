package alreadyknownalgo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FibonacciSeriesDnQ {

	public static void main(String[] args) {

		//generate using for loop
		//int[] generateSeriesForLoop = generateSeriesForLoop(15);
		int[] generateUsingRecursion = generateUsingRecursion(15);
		String numbersSorted= Arrays.stream(generateUsingRecursion).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println(numbersSorted);
		
	}
	
	public static int[] generateSeriesForLoop(int size) {
		int[] series = new int[size];
		series[0] = 0;
		series[1] = 1;
		for(int j=2; j < series.length ; j++) {
			series[j] = series[j-1]+ series[j-2];
		}
		return series;
	}
	
	//using recursion
	public static int[] generateUsingRecursion(int size) {
		int[] series = new int[size];
		runSeries(series,0);
		return series;
	}

	private static void runSeries(int[] series, int index) {
		if(index == series.length) {
			//after last iteration lets break the loop
			return;
		}
		if(index==0 || index==1) {
			series[index] = index;
			runSeries(series, index+1);
			return;
		}
		series[index] = series[index-1]+series[index-2];
		runSeries(series, index+1);
	}

}
