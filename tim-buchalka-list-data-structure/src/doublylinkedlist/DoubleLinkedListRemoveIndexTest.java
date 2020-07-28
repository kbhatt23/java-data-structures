package doublylinkedlist;

import util.Employee;

public class DoubleLinkedListRemoveIndexTest {
public static void main(String[] args) {
	DoubleLinkedList<Employee> list = new DoubleLinkedList<Employee>();
	list.insert( new Employee(1, "ganesh", 101));
	list.insert(1, new Employee(2, "mahesh", 999));
	//list.insert( new Employee(3, "krishna", 108));
	//list.insert( 2,new Employee(4, "radha", 111));
	//list.insert( 4,new Employee(5, "damodar", 10));
	//list.printAllNodes();
	list.printAllNodes();
	System.out.println(list.size());
	list.remove(0);
	list.insert( new Employee(3, "krishna", 108));
	list.remove(1);
	list.insert( 1,new Employee(4, "radha", 111));
	list.insert( 2,new Employee(5, "damodar", 10));
	System.out.println(list.size());
	list.printAllNodes();
	
	System.out.println("compelx removal");
	list.remove(0);
	list.printAllNodes();
	System.out.println(list.size());
}
}
