package countmethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Employee;
import util.SortObject;
import util.SortUtility;

public class SelfLearnedCountMethodSortObj extends SortObject {
	public static void main(String[] args) {
		boolean isReverseSort = true;
		SelfLearnedCountMethodSortObj obj = new SelfLearnedCountMethodSortObj();
		obj.sortManipulation(isReverseSort, SortUtility.findAllDistributedEmployees());
	}

	@Override
	public void sort(Employee[] employees) {
		Employee max = SortUtility.findMaxAge(employees);
		Employee min = SortUtility.findMinAge(employees);
		int[] tempArray = new int[max.getAge() - min.getAge() + 1];
		Map<Integer, List<Employee>> collissionMap = new HashMap<Integer, List<Employee>>();
		//int[] numbers = { 4, 7, 3, 2, 8, 10, 6, 7, 3, 10 };
		for (int i = 0; i < employees.length; i++) {
			int number = employees[i].getAge();
			int tempArrayIndex = number - min.getAge();
			int existingCount = tempArray[tempArrayIndex];
			tempArray[tempArrayIndex] = existingCount + 1;
			List<Employee> list = null;
			if (collissionMap.containsKey(number)) {
				list = collissionMap.get(number);
				list.add(employees[i]);
			} else {
				list = new ArrayList<Employee>();
				list.add(employees[i]);
			}
			collissionMap.put(number, list);
		}
		
		int mainArrayIndex = 0;
		for(int i=0; i< tempArray.length; i++) {
			int numberCount = tempArray[i];
			if(numberCount == 0) {
				continue;
			}
			int numberToInsert = i+min.getAge();
			for(int startIndex = 0 ; startIndex < numberCount ; startIndex++) {
				employees[mainArrayIndex] = collissionMap.get(numberToInsert).get(startIndex);
				mainArrayIndex++;
			}
			
		}
	}

	@Override
	public void reverseSort(Employee[] employees) {
		Employee max = SortUtility.findMaxAge(employees);
		Employee min = SortUtility.findMinAge(employees);
		int[] tempArray = new int[max.getAge() - min.getAge() + 1];
		Map<Integer, List<Employee>> collissionMap = new HashMap<Integer, List<Employee>>();
		//int[] numbers = { 4, 7, 3, 2, 8, 10, 6, 7, 3, 10 };
		for (int i = 0; i < employees.length; i++) {
			int number = employees[i].getAge();
			int tempArrayIndex = number - min.getAge();
			int existingCount = tempArray[tempArrayIndex];
			tempArray[tempArrayIndex] = existingCount + 1;
			List<Employee> list = null;
			if (collissionMap.containsKey(number)) {
				list = collissionMap.get(number);
				list.add(employees[i]);
			} else {
				list = new ArrayList<Employee>();
				list.add(employees[i]);
			}
			collissionMap.put(number, list);
		}
		
		int mainArrayIndex = 0;
		for(int i=tempArray.length-1; i>=0; i--) {
			int numberCount = tempArray[i];
			if(numberCount == 0) {
				continue;
			}
			int numberToInsert = i+min.getAge();
			for(int startIndex = 0 ; startIndex < numberCount ; startIndex++) {
				employees[mainArrayIndex] = collissionMap.get(numberToInsert).get(startIndex);
				mainArrayIndex++;
			}
			
		}
	
	}
}