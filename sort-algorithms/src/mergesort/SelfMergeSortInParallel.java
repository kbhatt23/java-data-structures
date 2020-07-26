package mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import util.SortUtility;

public class SelfMergeSortInParallel extends MergeSort{
	public static void main(String[] args) {
		boolean isReverseSort = false;
		SelfMergeSortInParallel obj = new SelfMergeSortInParallel();
		obj.sortManipulation(isReverseSort, SortUtility.findAllNumbers());
		//obj.sortManipulation(isReverseSort, new int[] {20,35,-15,7,55,1,-22});
	}
	
	@Override
	public void sort(int[] numbers) {
		int availableProcessors = 2;
		int iteration = numbers.length/availableProcessors;
		int remaining =  numbers.length - (iteration*availableProcessors);
		int[][] bucketOfArrays = new int[availableProcessors][];
		int i=0 ;
		for(; i < bucketOfArrays.length-1; i++) {
			bucketOfArrays[i] = new int[iteration];
		}
		bucketOfArrays[i] =new int[iteration+remaining] ;
		int itemIteration = 0;
		for(int k =0 ; k< bucketOfArrays.length ; k++) {
			int[] currentArray = bucketOfArrays[k];
			for(int l=0; l < currentArray.length; l++) {
				currentArray[l] = numbers[itemIteration];
				itemIteration++;
			}
		}
		Runnable threadRunner = null;
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(availableProcessors);
		List<Future<?>> futures = new ArrayList<Future<?>>(availableProcessors);
		for(int[] currentArray : bucketOfArrays) {
			threadRunner = () -> Arrays.sort(currentArray);
			futures.add(newFixedThreadPool.submit(threadRunner));
		}
		for(Future<?> future :futures) {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("shuruat");
		SortUtility.printArray(SortUtility.mergeTwoSortedArrays(bucketOfArrays[0], bucketOfArrays[1]));
		System.out.println("end");
	}
}
