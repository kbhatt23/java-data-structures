package selflearning.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EmployeeUtils {
	public static Employee[] populateEmployeeData() {
		Employee[] employees = {new Employee("radha", 23, 2323) , new Employee("shyam", 23, 9999) ,new Employee("ram", 99, 99999)
				,new Employee("sita", 90, 9000),new Employee("hanuman", 1, 1),new Employee("keshav", 66, 6666),new Employee("shankar", 101, 10101),
				
				new Employee("mata kalika", 1008, 10101), new Employee("narayan", 108, 10101), new Employee("brahma", 1007, 10101)
		};
		return employees;
	}
	
	public static void printEmployee(Employee[] employees) {
		Arrays.stream(employees).forEach(System.out::println);
	}
	
	public static void printNumbers(int[] numbers) {
		String numbersSorted= Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println(numbersSorted);
	}
}
