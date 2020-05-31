package selfllearning.ds.stack.usingarrays;

public class StackRemovalTest {

	public static void main(String[] args) {
		StackUsingArrays stack = new StackUsingArrays(3);
		stack.push(23);
		stack.push(24);
		stack.push(25);
		stack.deleteStack();
		//System.out.println(stack.size());
		//System.out.println(stack.hasCapacity());
		//System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());
	}

}
