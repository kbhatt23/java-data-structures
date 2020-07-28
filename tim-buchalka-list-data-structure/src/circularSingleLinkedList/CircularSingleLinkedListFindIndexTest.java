package circularSingleLinkedList;

import java.util.List;

import util.Employee;

public class CircularSingleLinkedListFindIndexTest {
	public static void main(String[] args) throws InterruptedException {
		CircularSingleLinkedList<Employee> list = new CircularSingleLinkedList<Employee>();
		list.insert(new Employee(1, "ganesh", 101));
		list.insert(new Employee(2, "mahesh", 99999));
		list.insert(2, new Employee(3, "radha", 1008));
		list.insert(3, new Employee(4, "extra", 1008));
		list.insert(new Employee(5, "krishna", 108));
		// list.insert(6,new Employee(6, "keshav", 108));
		list.insert(5, new Employee(6, "keshav", 108));
		 //list.printAllNodes();
		System.out.println(list.findCurrentAndPresviousNodes(1).get(0).getValue());
		System.out.println(list.findCurrentAndPresviousNodes(1).get(1).getValue());
	}
}
