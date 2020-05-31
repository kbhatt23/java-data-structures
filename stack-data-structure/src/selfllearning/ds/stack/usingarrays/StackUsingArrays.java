package selfllearning.ds.stack.usingarrays;
//internally arrays will be used to sore data

import selfllearning.ds.stack.Istack;

public class StackUsingArrays implements Istack {
	// making it finla so that a new array can not be added anyhow
	private  int[] storage;

	// user need to provide the size
	public StackUsingArrays(int size) {
		// array can not take negative size as it gives runtime excption
		// for case when size is 0 it can not hold value
		if (size < 1) {
			throw new RuntimeException("stack should have atleast one size");
		}
		storage = new int[size];
	}

	// not final as we will update on evry addition and removal in push and pop
	// respectively
	// default val is -1 as when first elment added it becomes 0 which is actual
	// index of array
	private int stackTop = -1;

	@Override
	public int size() {
		if(storage == null) {
			throw new RuntimeException("Stack is deleted");
		}
		return storage.length;
	}

	@Override
	public boolean isEmpty() {
		// means no data is inserted in stack
		return stackTop == -1;
	}

	@Override
	public boolean isFull() {
		return stackTop == size() - 1;
	}

	@Override
	public void push(int value) {
		if (isFull()) {
			throw new RuntimeException("Stack is full");
		}
		stackTop++;
		storage[stackTop] = value;
	}

	@Override
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		int value = storage[stackTop];
		// removal from index;
		stackTop--;
		return value;
	}

	@Override
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		// no need of removing item and hence not reducing stack top index
		return storage[stackTop];
	}

	@Override
	public boolean hasCapacity() {
		//meaning more items can be legally added
		//anything which is not full has valid capacity
		return !isFull();
	}

	@Override
	public void deleteStack() {
		//removing the stack
			storage = null;
	}

}
