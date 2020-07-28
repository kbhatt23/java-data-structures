package singlelinkedlist;

import util.Employee;

public class SingleLinkedListInsertIndexTest {
public static void main(String[] args) {

	SingleLinkedList<Employee> singleLinkedList = new SingleLinkedList<Employee>();
	singleLinkedList.insert(new Employee(1, "kanha", 1008));
	singleLinkedList.insert(1, new Employee(2, "radha", 111));
	singleLinkedList.insert(new Employee(3, "hanuman", 999999));
	singleLinkedList.insert(0,new Employee(4, "ganesh", 101));
	singleLinkedList.insert(4,new Employee(5, "mahesh", 99));
	System.out.println("size "+singleLinkedList.size());
	singleLinkedList.printAllNodes();

}
}
