package selfllearning.ds.stack.usinglinkedlist.headonly;

import selfllearning.ds.stack.Istack;

//easier implemenetaion to give same usage for users
public class StackUsingSingleLinkedList implements Istack {
	// head is enough to represent stack top
	private HeadTailNode head;

	@Override
	public int size() {
		if (isEmpty())
			return 0;
		SingleLinkedListNode node = head.getNode();
		int size = 0;
		while (true) {
			size++;
			if (node.getNext() == null) {
				break;
			}
			node = node.getNext();
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean isFull() {
		// never full
		return false;
	}

	@Override
	public void push(int value) {
		SingleLinkedListNode node = new SingleLinkedListNode(value, null);
		if (isEmpty()) {
			head = new HeadTailNode(node, RootType.HEAD);
		} else {
			node.setNext(head.getNode());
			head.setNode(node);
		}
	}

	@Override
	public int pop() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty");
		int value = head.getNode().getValue();
		if (size() == 1) {
			head = null;
		} else {
			head.setNode(head.getNode().getNext());
		}
		return value;

	}

	@Override
	public int peek() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty");
		return head.getNode().getValue();
	}

	@Override
	public boolean hasCapacity() {
		// always have capacity
		return true;
	}

	@Override
	public void deleteStack() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty");
		head = null;
	}

}
