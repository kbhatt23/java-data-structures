package util;

public abstract class SortObject {
	public abstract void sort(Employee[] employees);

	public abstract void reverseSort(Employee[] employees);

	public void sortManipulation(boolean isReverseSort, Employee[] employees) {
		if (isReverseSort) {
			reverseSort(employees);
		} else {
			sort(employees);
		}
		SortUtility.printObject(employees);
	}


}
