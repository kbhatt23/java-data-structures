package circularSingleLinkedList;

import util.Employee;

public class CircularSingleLinkedListRemoveListTest {
public static void main(String[] args) throws InterruptedException {
	CircularSingleLinkedList<Employee> list = new CircularSingleLinkedList<Employee>();
	list.insert(new Employee(1, "ganesh", 101));
	list.insert(new Employee(2, "mahesh", 99999));
	list.insert(2,new Employee(3, "radha", 1008));
	//list.insert(3,new Employee(4, "extra", 1008));
	//list.insert(new Employee(5, "krishna", 108));
	//list.insert(6,new Employee(6, "keshav", 108));
	//list.insert(5,new Employee(6, "keshav", 108));
	//list.printAllNodes();
	System.out.println(list.size());
	list.printAllNodes();
	System.out.println("remogin now");
	list.remove(2);
	list.printAllNodes();
	//list.printNodesInfinite();
	System.out.println(list.findIndex(new Employee(2, "mahesh", 99999)));
	
}
}
