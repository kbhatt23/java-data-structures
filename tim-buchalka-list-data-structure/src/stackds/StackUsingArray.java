package stackds;

public class StackUsingArray<T> implements IStack<T> {
	private Object[] storage;
	private int headIndex = 0;

	public StackUsingArray(int initialSize) {
		this.storage = new Object[initialSize];
	}

	public StackUsingArray() {
		this.storage = new Object[10];
	}

	@Override
	public int size() {
		return headIndex;
	}

	@Override
	public boolean isEmpty() {
		return headIndex == 0;
	}

	// mostlu used internally
	// as we are having a growing array
	@Override
	public boolean isFull() {
		return storage.length == headIndex;
	}

	@Override
	public void push(T value) {
		if (isFull()) {
			// lets grow the array
			grow();
		}
		storage[headIndex++] = value; 
	}

	private void grow() {
		System.out.println("growing exising array");
		// lets move to 10 later on
		Object[] newArray = new Object[storage.length + 2];
		for (int i = 0; i < storage.length; i++) {
			newArray[i] = storage[i];
		}
		storage = newArray;
	}

	@Override
	public T pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is already empty");
		}
		T value = (T)storage[--headIndex];
		return value;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is already empty");
		}
		int indexToFind = headIndex-1;
		T value = (T)storage[indexToFind];
		return value;
	}

	@Override
	public void deleteStack() {
		storage = null;
		headIndex=0;
	}

}
