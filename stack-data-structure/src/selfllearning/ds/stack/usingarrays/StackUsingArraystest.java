package selfllearning.ds.stack.usingarrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackUsingArraystest {
	@Test
	void emptyStackNotAllowed() {
		Assertions.assertThrows(RuntimeException.class,() -> {
			StackUsingArrays stack = new StackUsingArrays(0);
			stack.push(99);
		});
		
	}
	
	@Test
	public void stackSizeOperations() {
		StackUsingArrays stack = new StackUsingArrays(2);
		assertEquals(2, stack.size());
		//assertEquals(3, stack.size());
	}
	@Test
	public void stackPushOperationsFail() {
		
		Assertions.assertThrows(RuntimeException.class,() -> {
			StackUsingArrays stack = new StackUsingArrays(2);
			stack.push(23);
			stack.push(24);
			//shud throw exception
			stack.push(99);
		});
	}

}
