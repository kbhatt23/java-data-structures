package mergesort;

import util.Employee;
import util.SortObject;
import util.SortUtility;

public class MergeSortObject extends SortObject {
	public static void main(String[] args) {
		boolean isReverseSort = true;
		MergeSortObject obj = new MergeSortObject();
		obj.sortManipulation(isReverseSort, SortUtility.findAllEmployees());
	}


	private void mergeSortRecursively(Employee[] employees, int start, int end) {
		if (end > start) {
			int mid = (start + end) / 2;
			mergeSortRecursively(employees, start, mid);
			mergeSortRecursively(employees, mid + 1, end);
			merge(employees, start, end, mid);
		}
	}

	private void merge(Employee[] employees, int start, int end, int mid) {
		int sizeLeft = mid - start + 1;
		int sizeRight = end - mid;
		Employee[] leftArray = new Employee[sizeLeft];
		Employee[] rightArray = new Employee[sizeRight];
		for (int i = 0; i < sizeLeft; i++) {
			leftArray[i] = employees[i + start];
		}
		for (int i = 0; i < sizeRight; i++) {
			rightArray[i] = employees[mid + 1 + i];
		}
		int a = 0;
		int b = 0;
		int c = start;
		while (a < sizeLeft && b < sizeRight) {
			if (leftArray[a].getAge() <= rightArray[b].getAge()) {
				employees[c] = leftArray[a];
				a++;
			} else {
				employees[c] = rightArray[b];
				b++;
			}
			c++;
		}
		while (a < sizeLeft) {
			employees[c] = leftArray[a];
			a++;
			c++;
		}
		while (b < sizeRight) {
			employees[c] = rightArray[b];
			b++;
			c++;
		}
	}


	@Override
	public void sort(Employee[] employees) {
		mergeSortRecursively(employees, 0, employees.length-1);
	}


	@Override
	public void reverseSort(Employee[] employees) {
		mergeReverseSortRecursively(employees, 0, employees.length-1);
	}
	
	private void mergeReverseSortRecursively(Employee[] employees, int start, int end) {
		if (end > start) {
			int mid = (start + end) / 2;
			mergeReverseSortRecursively(employees, start, mid);
			mergeReverseSortRecursively(employees, mid + 1, end);
			mergeReverse(employees, start, end, mid);
		}
	}

	private void mergeReverse(Employee[] employees, int start, int end, int mid) {
		int sizeLeft = mid - start + 1;
		int sizeRight = end - mid;
		Employee[] leftArray = new Employee[sizeLeft];
		Employee[] rightArray = new Employee[sizeRight];
		for (int i = 0; i < sizeLeft; i++) {
			leftArray[i] = employees[i + start];
		}
		for (int i = 0; i < sizeRight; i++) {
			rightArray[i] = employees[mid + 1 + i];
		}
		int a = 0;
		int b = 0;
		int c = start;
		while (a < sizeLeft && b < sizeRight) {
			if (leftArray[a].getAge() >= rightArray[b].getAge()) {
				employees[c] = leftArray[a];
				a++;
			} else {
				employees[c] = rightArray[b];
				b++;
			}
			c++;
		}
		while (a < sizeLeft) {
			employees[c] = leftArray[a];
			a++;
			c++;
		}
		while (b < sizeRight) {
			employees[c] = rightArray[b];
			b++;
			c++;
		}
	}

}
