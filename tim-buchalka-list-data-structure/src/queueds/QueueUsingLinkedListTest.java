package queueds;

import util.Employee;

public class QueueUsingLinkedListTest {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "ganesh", 101);
		Employee e2 = new Employee(2, "mahesh", 999);
		Employee e3 = new Employee(3, "suresh", 108);
		Employee e4 = new Employee(4, "damodar", 11);
		Employee e5 = new Employee(5, "radha", 111);
		IQueue<Employee> queue = new QueueUsingLinkedList<Employee>();
		System.out.println(queue.peekQueue());
		System.out.println(queue.size() + " "+ queue.isEmpty() );
		queue.enQueue(e1);
		System.out.println(queue.peekQueue());
		System.out.println(queue.size() + " "+ queue.isEmpty() );
		queue.deleteQueue();
		System.out.println(queue.peekQueue());
		System.out.println(queue.size() + " "+ queue.isEmpty() );
		queue.enQueue(e1);
		queue.enQueue(e2);
		System.out.println(queue.peekQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.size() + " "+ queue.isEmpty() );
		
	}

}
