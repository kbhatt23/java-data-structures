package selfllearning.ds.stack.usinglinkedlist;

import selfllearning.ds.stack.Istack;

//best use case looks like a double linked list for stack operations
//size is dynamic
public class StackUsingLinkedList implements Istack {

	private HeadTailNode head;

	private HeadTailNode tail;

	@Override
	public int size() {
		if (isEmpty())
			return 0;
		// no need case getting hanlded in while loop itslef at line 24
		// if(head.getNode() == tail.getNode()) {
		// only one element present in linked list
		// return 1;
		// }
		int size = 0;
		DoubleLinkedListNode node = head.getNode();
		while (true) {
			size++;
			if (tail.getNode() == node) {
				break;
			}
			node = node.getNext();
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null && tail == null;
	}

	@Override
	public boolean isFull() {
		// never full
		return false;
	}

	@Override
	public void push(int value) {
		// insertion at the last is called push
		DoubleLinkedListNode node = new DoubleLinkedListNode(value, null, null);
		if (isEmpty()) {
			// first time entry is added -> head and tail point to same node
			head = new HeadTailNode(node, RootType.HEAD);
			tail = new HeadTailNode(node, RootType.HEAD);
		} else {
			DoubleLinkedListNode currentLastNode = tail.getNode();
			currentLastNode.setNext(node);
			node.setPrevious(currentLastNode);
			tail.setNode(node);
		}

	}

	@Override
	public int pop() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty");
		if (tail.getNode() == head.getNode()) {
			// only one item present
			int value = head.getNode().getValue();
			head = null;
			tail = null;
			return value;
		} else {
			DoubleLinkedListNode currentLastNode = tail.getNode();
			int value = currentLastNode.getValue();
			tail.setNode(currentLastNode.getPrevious());
			if (currentLastNode.getPrevious() != null)
				currentLastNode.getPrevious().setNext(null);
			return value;
		}

	}

	@Override
	public int peek() {
		if (isEmpty() || tail.getNode() == null)
			throw new RuntimeException("Stack is empty");
		DoubleLinkedListNode currentLastNode = tail.getNode();

		return currentLastNode.getValue();
	}

	@Override
	public boolean hasCapacity() {
		// always new item can be added
		return true;
	}

	@Override
	public void deleteStack() {
		DoubleLinkedListNode node = head.getNode();
		
		while (node != tail.getNode()) {
			node.getNext().setPrevious(null);
			node = node.getNext();
		}
		head = tail = null;
	}

}
