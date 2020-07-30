package bucketsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import util.Sort;
import util.SortUtility;

public class BucketSort extends Sort {
	public static void main(String[] args) {
		boolean isReverseSort = false;
		BucketSort obj = new BucketSort();
		obj.sortManipulation(isReverseSort, SortUtility.findRadisArrays());
	}

	@Override
	public void sort(int[] numbers) {
		//number of charachters are 10 and hence we are making 10
		//each indices will hold value starting from that
		int numberOfBuckets = (int)Math.sqrt(numbers.length);
		int max = Arrays.stream(numbers).max().orElseThrow(RuntimeException::new);
		System.out.println("max "+max);
		System.out.println("numberOfBuckets "+numberOfBuckets);
		List<List<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i < numberOfBuckets; i++) {
			List<Integer> bucket = new ArrayList<Integer>();
			buckets.add(bucket);
		}

		for (int i = 0; i < numbers.length; i++) {
			int bucketNumber = hash(numbers[i], max, numberOfBuckets);
			
			buckets.get(bucketNumber).add(numbers[i]);
		}

		for (List<Integer> bucket : buckets) {

			Collections.sort(bucket);

		}
		int index = 0;
		for (List<Integer> bucket : buckets) {

			for(int number: bucket) {
				numbers[index] = number;
				index++;
			}

		}
		
	}
	private static int hash(int i, int max, int numberOfBuckets) {
        return (int) ((double) i / max * (numberOfBuckets - 1));
    }

	@Override
	public void reverseSort(int[] numbers) {

	}

}
