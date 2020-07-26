package selectionsort;

import util.Employee;
import util.SortObject;
import util.SortUtility;

public class SelfSelectionSortObj extends SortObject {
	public static void main(String[] args) {
		
		boolean isReverseSort = false;
		SelfSelectionSortObj obj = new SelfSelectionSortObj();
		obj.sortManipulation(isReverseSort, SortUtility.findAllEmployees());
	}

	@Override
	public void sort(Employee[] employees) {
		for(int i=0; i < employees.length ; i++) {
			for(int j = i+1; j<employees.length ; j++) {
				Employee current = employees[i];
				Employee next = employees[j];
				if(next.getAge() < current.getAge()) {
					employees[i]= next;
					employees[j] = current;
				}
			}
				
		}
	}

	@Override
	public void reverseSort(Employee[] employees) {
		for(int i=0; i < employees.length ; i++) {
			for(int j = i+1; j<employees.length ; j++) {
				Employee current = employees[i];
				Employee next = employees[j];
				if(next.getAge() > current.getAge()) {
					employees[i]= next;
					employees[j] = current;
				}
			}
				
		}
	}

}
