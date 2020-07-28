package singlelinkedlist;

import util.Employee;

public class SingleLinkedListBasicInsertion {
public static void main(String[] args) {
	SingleLinkedList<Employee> singleLinkedList = new SingleLinkedList<Employee>();
	singleLinkedList.insert(new Employee(1, "kanha", 1008));
	singleLinkedList.insert(new Employee(2, "madhav", 108));
	singleLinkedList.insert(new Employee(3, "radha", 111));
	System.out.println("size is "+singleLinkedList.size());
	singleLinkedList.printAllNodes();
} 

}
