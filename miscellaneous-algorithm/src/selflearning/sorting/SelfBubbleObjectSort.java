package selflearning.sorting;

public class SelfBubbleObjectSort {

	public static void main(String[] args) {
		Employee[] employees = EmployeeUtils.populateEmployeeData();

		int length = employees.length;
		int recursionIteration = 0;
		int recursionEnd = length - 2;
		// bubble sort swapping
		while (recursionEnd != recursionIteration) {
			System.out.println("looping the array");
			int iterationEnd = length - 1-recursionIteration;
			for (int i = 0; i < iterationEnd; i++) {
				Employee currentObj = employees[i];
				Employee nextObj = employees[i + 1];
				if (nextObj.getAge() < currentObj.getAge()) {
					employees[i] = nextObj;
					employees[i + 1] = currentObj;
				}
			}
			recursionIteration++;
		}
		
		EmployeeUtils.printEmployee(employees);
	}

}
