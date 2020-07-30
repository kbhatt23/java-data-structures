package stackds;

import util.Employee;

public class StackUsingJDKTest {

	public static void main(String[] args) {
		StackUsingLinkedList<Employee> stack = new StackUsingLinkedList<>();
		Employee e1 = new Employee(1, "ganesh", 101);
		Employee e2 = new Employee(2, "mahesh", 999);
		Employee e3 = new Employee(3, "suresh", 108);
		Employee e4 = new Employee(4, "damodar", 11);
		Employee e5 = new Employee(5, "radha", 111);
		stack.push(e1);
		System.out.println(stack.peek());
		stack.push(e2);
		stack.push(e3);
		stack.push(e4);
		stack.push(e5);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println("pop ke baad "+stack.peek());
		stack.pop();
		System.out.println(stack.size());
		System.out.println(stack.isFull());
		System.out.println(stack.isEmpty());
		int size  =stack.size();
		for(int i =0 ; i<size; i++) {
			System.out.println("poping item "+stack.pop());
		}
		//stack.deleteStack();
		System.out.println(stack.isEmpty());
	
	}

}
