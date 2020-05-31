package selflearning.ds.queue.usingLinkedlist;

import selflearning.ds.queue.IQueue;

public class QueueUsingLinkedList implements IQueue {
	private HeadTailNode head;
	private HeadTailNode tail;

	@Override
	public int size() {
		if (head == null) {
			return 0;
		}
		DoubleLinkedListNode node = head.getNode();
		int size = 0;
		while (true) {
			size++;
			if (node == tail.getNode()) {
				break;
			}
			node = node.getNext();
		}
		return size;
	}

	@Override
	public boolean hasCapacity() {
		// always have capcity to add new element
		return true;
	}

	@Override
	public boolean isFull() {
		// never full
		return false;
	}

	@Override
	public boolean isEmpty() {
		// when size is 0 empty is true
		// other wise false
		return size() == 0;
	}

	@Override
	public int deQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		DoubleLinkedListNode currentFirstNode = head.getNode();
		int value = currentFirstNode.getValue();
		if (size() == 1) {
			// only one item present
			head = tail = null;
		} else {
			head.setNode(currentFirstNode.getNext());
			currentFirstNode.getNext().setPrevious(null);
		}
		return value;
	}

	@Override
	public int peekQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return head.getNode().getValue();
	}

	@Override
	public void enQueue(int value) {
		DoubleLinkedListNode node = new DoubleLinkedListNode(value, null, null);
		if (isEmpty()) {
			// data entry for the first time
			head = new HeadTailNode(node, RootType.HEAD);
			tail = new HeadTailNode(node, RootType.TAIL);
		} else {
			DoubleLinkedListNode currentLastNode = tail.getNode();
			tail.setNode(node);
			currentLastNode.setNext(node);
			node.setPrevious(currentLastNode);
		}
	}

	@Override
	public void deleteQueue() {
		DoubleLinkedListNode node = head.getNode();

		while (node != tail.getNode()) {
			node.getNext().setPrevious(null);
			node = node.getNext();
		}
		head = tail = null;
	}
}
