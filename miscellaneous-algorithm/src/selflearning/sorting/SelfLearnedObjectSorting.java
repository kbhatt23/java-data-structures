package selflearning.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SelfLearnedObjectSorting {
	public static void main(String[] args) {
		Employee[] employees = EmployeeUtils.populateEmployeeData();

		// sorting based on age
		for (int i = 0; i < employees.length; i++) {
			for (int j = i + 1; j < employees.length; j++) {
				Employee currentEmp = employees[i];
				int current = employees[i].getAge();
				Employee nextEmp = employees[j];
				int next = employees[j].getAge();
				if (next < current) {
					employees[i] = nextEmp;
					employees[j] = currentEmp;
				}
			}
		}
		EmployeeUtils.printEmployee(employees);
		System.out.println("using comparator class");
		Employee[] newEmployees = EmployeeUtils.populateEmployeeData();
		Arrays.sort(newEmployees, Comparator.comparing(Employee::getAge));
		EmployeeUtils.printEmployee(newEmployees);
	}
}
