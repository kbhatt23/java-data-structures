package doublylinkedlist;

import util.Employee;

public class DoubleLinkedListInsertTest {

	public static void main(String[] args) {
		DoubleLinkedList<Employee> list = new DoubleLinkedList<Employee>();
		list.insert(new Employee(1, "ganesh", 23));
		list.insert(new Employee(2, "krishna", 108));
		System.out.println(list.size());
		list.printAllNodes();
	}

}
