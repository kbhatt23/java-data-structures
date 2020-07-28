package singlelinkedlist;

import util.Employee;

public class SingleLinkedListReversePrintTest {
public static void main(String[] args) {
	SingleLinkedList<Employee> singleLinkedList = new SingleLinkedList<Employee>();
	singleLinkedList.insert(new Employee(1, "kanha", 1008));
	singleLinkedList.insert(1, new Employee(2, "radha", 111));
	singleLinkedList.insert(new Employee(3, "hanuman", 999999));
	singleLinkedList.insert(0,new Employee(4, "ganesh", 101));
	singleLinkedList.insert(4,new Employee(5, "mahesh", 99));
	singleLinkedList.remove(4);
	System.out.println("printing list with initial size "+singleLinkedList.size());
	singleLinkedList.printAllNodes();
	//System.out.println(singleLinkedList.findIndex(new Employee(5, "mahesh", 99)));
	singleLinkedList.findCurrentAndPresviousNodes(4)
	.forEach(System.out::println);
}
}
