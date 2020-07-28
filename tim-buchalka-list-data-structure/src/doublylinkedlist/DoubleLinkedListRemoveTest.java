package doublylinkedlist;

import util.Employee;

public class DoubleLinkedListRemoveTest {

	public static void main(String[] args) {
		DoubleLinkedList<Employee> list = new DoubleLinkedList<Employee>();
		list.insert( new Employee(1, "ganesh", 101));
		list.insert( new Employee(2, "mahesh", 999));
		list.removeList();
		System.out.println(list.size());
		System.out.println(list.isEmpty());
	}

}
