package selflearning.sorting;

public class SelectionSortRealObject {
	public static void main(String[] args) {

		Employee[] employees = EmployeeUtils.populateEmployeeData();
		System.out.println("Employees before sorting");
		EmployeeUtils.printEmployee(employees);
		
		for(int i =0; i < employees.length ; i++) {
			
			Employee smallestEmployee = employees[i];
			int smallestIndex = i;
			for(int j = i+1 ; j<employees.length ; j++) {
				if(employees[j].getAge() < smallestEmployee.getAge()) {
					smallestEmployee = employees[j];
					smallestIndex =j;
				}
			}
			//swap
			Employee currentIndexedEmployee = employees[i];
			employees[i] = employees[smallestIndex];
			employees[smallestIndex] = currentIndexedEmployee;
		}
		
		System.out.println("Employees after sorting");
		EmployeeUtils.printEmployee(employees);
		
	}
}
