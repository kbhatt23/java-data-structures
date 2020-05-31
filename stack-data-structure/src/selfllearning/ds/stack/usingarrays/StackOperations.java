package selfllearning.ds.stack.usingarrays;

public class StackOperations {
	public static void main(String[] args) {
		StackUsingArrays stack = new StackUsingArrays(3);
		System.out.println(stack.size());
		System.out.println(stack.hasCapacity());
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());
		System.out.println("after first manipulations");
		stack.push(23);
		stack.push(24);
		stack.push(25);
		System.out.println(stack.size());
		System.out.println(stack.hasCapacity());
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());
		if (stack.hasCapacity()) {
			System.out.println("trying adding item beyond capacity");
			stack.push(99);
		}
		System.out.println("latest item peek " + stack.peek());
		System.out.println("pop out one " + stack.pop());
		System.out.println("pop out one " + stack.pop());
		System.out.println("latest item peek " + stack.peek());
		//stack.pop();
		if (!stack.isEmpty()) {
			System.out.println("applicable latest item " + stack.peek());
		}
	}
}
