package circularSingleLinkedList;

import util.Employee;

public class CircularSingleLinkedListTest {
public static void main(String[] args) throws InterruptedException {
	CircularSingleLinkedList<Employee> list = new CircularSingleLinkedList<Employee>();
	list.insert(new Employee(1, "ganesh", 101));
	list.insert(new Employee(2, "radha", 1008));
	list.insert(new Employee(3, "krishna", 108));
	list.printAllNodes();
	//list.printNodesInfinite();
}
}
