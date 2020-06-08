package selflearning.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	public static void main(String[] args) {
		int[] numbers = { 23, 23, 99, 90, 1, 66, 101, 1008, 108, 1007 };

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
		EmployeeUtils.printNumbers(numbers);
		
	}
	private static int hash(int i, int max, int numberOfBuckets) {
        return (int) ((double) i / max * (numberOfBuckets - 1));
    }
}
