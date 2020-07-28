package doublylinkedlist;

import util.Employee;

public class DoubleLikedaDoubleLinkedListAddBeforeTest {

	public static void main(String[] args) {
		DoubleLinkedList<Employee> list = new DoubleLinkedList<Employee>();
		Employee e1 = new Employee(1, "ganesh", 101);
		Employee e2 = new Employee(2, "mahesh", 999);
		list.insert(e1);
		list.addBefore(e1, e2);
		list.printAllNodes();
		System.out.println("more manipualtion");
		Employee e3 = new Employee(3, "radha", 1001);
		list.addBefore(e1, e3);
		list.printAllNodes();
		System.out.println(list.size());
	}

}
