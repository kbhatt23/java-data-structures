package doublecircularlinkedlist;

import util.Employee;

public class DoubleCircularListInsertionTest {
public static void main(String[] args) throws InterruptedException {
	DoubleCircularLinkedList<Employee> list = new DoubleCircularLinkedList<Employee>();
	list.insert( new Employee(1, "ganesh", 101));
	list.insert( new Employee(2, "mahesh", 999));
	list.insert( new Employee(2, "suresh", 999));
	list.printNodesInfinite();
	//list.printReverseNodesInfinite();
}
}
