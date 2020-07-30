package queueds;

import util.Employee;

public class QueueUsingArraysTest {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "ganesh", 101);
		Employee e2 = new Employee(2, "mahesh", 999);
		Employee e3 = new Employee(3, "suresh", 108);
		Employee e4 = new Employee(4, "damodar", 11);
		Employee e5 = new Employee(5, "radha", 111);
		IQueue<Employee> queue = new QueueUsingArrays<Employee>(3);
		queue.enQueue(e1);
		queue.enQueue(e2);
		queue.enQueue(e3);
		System.out.println(queue.peekQueue());
		System.out.println("size "+ queue.size());
		System.out.println("isEmpty "+queue.isEmpty());
		System.out.println("isfull "+queue.isFull());
		queue.enQueue(e4);
		int size = queue.size();
		for(int i=0 ; i< size ; i++) {
			System.out.println("popping out "+queue.deQueue());
		}
		System.out.println("is empty after all pop "+queue.isEmpty());
		if(!queue.isEmpty()) {
			System.out.println("after popping out all "+queue.peekQueue());
		}
		System.out.println("final addition");
		queue.enQueue(e5);
		if(!queue.isEmpty()) {
			System.out.println("after popping out all "+queue.peekQueue());
		}
	}

}
