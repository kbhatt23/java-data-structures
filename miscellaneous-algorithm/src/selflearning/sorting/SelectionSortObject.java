package selflearning.sorting;

import java.util.HashSet;
import java.util.Set;

public class SelectionSortObject {
public static void main(String[] args) {
	Employee[] employees = EmployeeUtils.populateEmployeeData();
	
	System.out.println("employees before sorting");
	EmployeeUtils.printEmployee(employees);
	
	Employee[] sortedEmployees = new Employee[employees.length];
	Set<Integer> minimumIndices= new HashSet<Integer>();
	for(int i=0; i <sortedEmployees.length; i++) {
		Employee smallestEmployee =employees[0];
		int smallestIndex = 0;
		for(int j = 1 ; j<employees.length ; j++) {
			if(minimumIndices.contains(j)) {
				continue;
			}
			if(employees[j].getAge() < smallestEmployee.getAge()) {
				smallestEmployee = employees[j];
				smallestIndex = j;
			}
		
		
		}
		minimumIndices.add(smallestIndex);
		sortedEmployees[i] = smallestEmployee;
		employees[smallestIndex] = new Employee("completed", Integer.MAX_VALUE, 999999999);
	}
	System.out.println("employees after sorting");
	EmployeeUtils.printEmployee(sortedEmployees);
}
}
