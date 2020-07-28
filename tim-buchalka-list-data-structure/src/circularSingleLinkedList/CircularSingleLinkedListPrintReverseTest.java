package circularSingleLinkedList;

import util.Employee;

public class CircularSingleLinkedListPrintReverseTest {
public static void main(String[] args) {
	CircularSingleLinkedList<Employee> list = new CircularSingleLinkedList<Employee>();
	list.insert(new Employee(1, "ganesh", 101));
	list.insert(new Employee(2, "mahesh", 99999));
	list.insert(new Employee(3, "krishna", 99999));
	list.printeReverse();
}
}
