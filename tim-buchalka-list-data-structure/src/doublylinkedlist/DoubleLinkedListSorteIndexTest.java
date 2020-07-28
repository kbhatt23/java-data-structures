package doublylinkedlist;

import util.Employee;

public class DoubleLinkedListSorteIndexTest {

	public static void main(String[] args) {

		DoubleLinkedList<Employee> list = new DoubleLinkedList<Employee>();
		Employee e1 = new Employee(1, "ganesh", 101);
		Employee e2 = new Employee(2, "mahesh", 999);
		Employee e3 = new Employee(3, "karthik", 107);
		Employee e5 = new Employee(4, "damodar", 900);
		Employee e4 = new Employee(5, "krishna", 900);
		list.insert(e2);
		list.insertSortedByAge(e1);
		list.insertSortedByAge(e3);
		list.insertSortedByAge(e4);
		list.insertSortedByAge(e5);
		list.printAllNodes();
		System.out.println(list.size());

	}
}
