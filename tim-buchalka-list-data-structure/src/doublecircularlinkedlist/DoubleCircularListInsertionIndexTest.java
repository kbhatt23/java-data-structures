package doublecircularlinkedlist;

import util.Employee;

public class DoubleCircularListInsertionIndexTest {
public static void main(String[] args) throws InterruptedException {
	DoubleCircularLinkedList<Employee> list = new DoubleCircularLinkedList<Employee>();
	list.insert( new Employee(1, "ganesh", 101));
	System.out.println(list.findIndex(new Employee(1, "ganesh", 101)));
	list.insert(new Employee(2, "mahesh", 999));
	System.out.println(list.findIndex(new Employee(1, "ganesh", 101)));
	list.insert(2, new Employee(3, "suresh", 999));
	System.out.println(list.size());
	list.printAllNodes();
	System.out.println(list.findIndex(new Employee(3, "suresh", 999)));
	
	
}
}
