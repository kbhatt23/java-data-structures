package doublecircularlinkedlist;

import util.Employee;

public class DoubleCircularListRemoveTest {
public static void main(String[] args) throws InterruptedException {
	DoubleCircularLinkedList<Employee> list = new DoubleCircularLinkedList<Employee>();
	list.insert( new Employee(1, "ganesh", 101));
	list.remove(0);
	list.insert(new Employee(2, "mahesh", 999));
	list.insert(1, new Employee(2, "suresh", 999));
	System.out.println(list.size());
	list.printAllNodes();
	list.remove(1);
	list.insert(new Employee(3, "krishna", 999));
	list.insert(new Employee(4, "radha", 999));
	System.out.println("printing afterremove");
	list.printAllNodes();
	//list.printAllNodes();
	//list.printAllNodesReverse();
	list.remove(0);
	System.out.println("printing after 3rd level of remoal");
	//list.printNodesInfinite();
	list.printReverseNodesInfinite();
	
}
}
