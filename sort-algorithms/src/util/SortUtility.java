package util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortUtility {
	public static void printArray(int[] numbers) {
		System.out.println("starting to print sorted array");
		String items = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println("array items are " + items);
	}

	public static void printObject(Employee[] employees) {
		System.out.println("starting to print sorted array");
		String items = Arrays.stream(employees).map(Employee::toString).collect(Collectors.joining(","));
		System.out.println("array items are " + items);
	}

	public static Employee[] findAllEmployees() {
		Employee e1 = new Employee(23, "kaka");
		Employee e2 = new Employee(23, "zaha");
		Employee e3 = new Employee(99, "radha");
		Employee e4 = new Employee(90, "uma shankar");
		Employee e5 = new Employee(1, "mahadev");
		Employee e6 = new Employee(66, "keshav");
		Employee e7 = new Employee(101, "raghav");
		Employee e8 = new Employee(1008, "hanuman");
		Employee e9 = new Employee(108, "surya devta");
		Employee e10 = new Employee(1007, "shani devta");
		return new Employee[] { e1, e2, e3, e4, e5, e6, e7, e8, e9, e10 };
	}

	public static int[] findAllNumbers() {
		int[] numbers = { 23, 23, 99, 90, 1, 66, 101, 1008, 108, 1007 };
		return numbers;
	}

	public static int[] findAllDistributedNumbers() {
		// int[] numbers = { 4,7,3,2,8,10,6,7,1,10 };
		int[] numbers = { 4, 7, 3, 2, 8, 10, 6, 7, 3, 10 };
		return numbers;
	}

	public static Employee[] findAllDistributedEmployees() {
		Employee e1 = new Employee(4, "kaka");
		Employee e2 = new Employee(7, "zaha");
		Employee e3 = new Employee(3, "radha");
		Employee e4 = new Employee(2, "uma shankar");
		Employee e5 = new Employee(8, "mahadev");
		Employee e6 = new Employee(10, "keshav");
		Employee e7 = new Employee(6, "raghav");
		Employee e8 = new Employee(7, "hanuman");
		Employee e9 = new Employee(3, "surya devta");
		Employee e10 = new Employee(10, "shani devta");
		return new Employee[] { e1, e2, e3, e4, e5, e6, e7, e8, e9, e10 };
	}

	public static int findMinNumber(int[] numbers) {
		int min = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			int current = numbers[i];
			if (current < min) {
				min = current;
			}
		}
		return min;
	}

	public static int findMaxNumber(int[] numbers) {
		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			int current = numbers[i];
			if (current > max) {
				max = current;
			}
		}
		return max;
	}

	public static Employee findMinAge(Employee[] employees) {
		Employee min = employees[0];
		for (int i = 1; i < employees.length; i++) {
			Employee current = employees[i];
			if (current.getAge() < min.getAge()) {
				min = current;
			}
		}
		return min;
	}

	public static Employee findMaxAge(Employee[] employees) {
		Employee max = employees[0];
		for (int i = 1; i < employees.length; i++) {
			Employee current = employees[i];
			if (current.getAge() > max.getAge()) {
				max = current;
			}
		}
		return max;
	}

	public static void copyArray(int[] source, int[] destination) {
		if (source.length != destination.length)
			throw new RuntimeException("array copy not supported");
		for (int i = 0; i < source.length; i++) {
			destination[i] = source[i];
		}
	}

	public static void swap(int i, int j, int[] numbers) {
		int existing = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = existing;
	}

	public static int[] mergeTwoSortedArrays(int[] array1, int[] array2) {
		int[] merged = new int[array1.length + array2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < array1.length && j < array2.length) {
			if (array1[i] <= array2[j]) {
				merged[k] = array1[i];
				i++;
			} else {
				merged[k] = array2[j];
				j++;
			}
			k++;
		}
		while (i < array1.length) {
			merged[k] = array1[i];
			i++;
			k++;
		}
		while (j < array2.length) {
			merged[k] = array2[j];
			j++;
			k++;
		}
		return merged;
	}
}
