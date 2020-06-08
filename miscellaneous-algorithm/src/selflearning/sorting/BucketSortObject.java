package selflearning.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BucketSortObject {
	public static void main(String[] args) {
		Employee[] employees = EmployeeUtils.populateEmployeeData();

		int numberOfBuckets = (int) Math.sqrt(employees.length);
		int max = Arrays.stream(employees).max(Comparator.comparing(Employee::getAge)).map(Employee::getAge)
				.orElseThrow(RuntimeException::new);
		int max1 = Arrays.stream(employees).mapToInt(Employee::getAge).max().orElseThrow(RuntimeException::new);
		System.out.println("max " + max);
		System.out.println("numberOfBuckets " + numberOfBuckets);
		List<List<Employee>> buckets = new ArrayList<>();
		for (int i = 0; i < numberOfBuckets; i++) {
			List<Employee> bucket = new ArrayList<Employee>();
			buckets.add(bucket);
		}

		for (int i = 0; i < employees.length; i++) {
			int bucketNumber = hash(employees[i].getAge(), max, numberOfBuckets);

			buckets.get(bucketNumber).add(employees[i]);
		}

		for (List<Employee> bucket : buckets) {

			Collections.sort(bucket, Comparator.comparing(Employee::getAge));

		}
		int index = 0;
		for (List<Employee> bucket : buckets) {
			for (Employee number : bucket) {
				employees[index] = number;
				index++;
			}
		}
		EmployeeUtils.printEmployee(employees);
	}

	private static int hash(int i, int max, int numberOfBuckets) {
		return (int) ((double) i / max * (numberOfBuckets - 1));
	}
}
