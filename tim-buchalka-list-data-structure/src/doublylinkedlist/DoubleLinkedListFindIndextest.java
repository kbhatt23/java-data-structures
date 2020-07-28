package doublylinkedlist;

import util.Employee;

public class DoubleLinkedListFindIndextest {

	public static void main(String[] args) {
		DoubleLinkedList<Employee> list = new DoubleLinkedList<Employee>();
		list.insert( new Employee(1, "ganesh", 101));
		list.insert( new Employee(2, "mahesh", 999));
		System.out.println(list.findIndex(new Employee(2, "mahesh", 999)));
	}

}
