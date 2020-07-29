package stackds;

import singlelinkedlist.SingleLinkedList;

public class StackUsingLinkedList<T> implements IStack<T> {
	// using linked list
	SingleLinkedList<T> linkedList = new SingleLinkedList<>();

	@Override
	public int size() {
		return linkedList.size();
	}

	@Override
	public boolean isEmpty() {
		return (linkedList == null || linkedList.size() == 0);
	}

	@Override
	public boolean isFull() {
		// never full linked list is every frowing
		return false;
	}

	@Override
	public void push(T value) {
		if (linkedList.isEmpty()) {
			linkedList.insert(value);
		} else {
			linkedList.insert(0, value);
		}
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is already empty");
		}
		T value = linkedList.findCurrentAndPresviousNodes(0).get(0).getValue();
		linkedList.remove(0);
		return value;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is already empty");
		}
		T value = linkedList.findCurrentAndPresviousNodes(0).get(0).getValue();
		return value;
	}

	@Override
	public void deleteStack() {
		linkedList.removeList();
		linkedList = null;
	}

}
