package doublecircularlinkedlist;

import java.util.Arrays;
import java.util.List;

import common.DoubleLinkedListNode;
import common.HeadTailDoubleNode;
import common.RootType;

public class DoubleCircularLinkedList<T> {
	private HeadTailDoubleNode<T> head;
	private HeadTailDoubleNode<T> tail;
	// extra feature so that size method become O(1)
	private int tailIndex = 0;

	public void insert(T value) {
		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(value, null, null);
		if (isEmpty()) {
			head = new HeadTailDoubleNode<T>(RootType.HEAD, node);
			tail = new HeadTailDoubleNode<T>(RootType.TAIL, node);
		} else {
			tail.getNode().setNext(node);
			node.setPrevious(tail.getNode());
			tail.setNode(node);
		}
		head.getNode().setPrevious(tail.getNode());
		tail.getNode().setNext(head.getNode());
		tailIndex++;
	}

	public void printNodesInfinite() throws InterruptedException {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		// simulating to print whole list only once
		DoubleLinkedListNode<T> node = head.getNode();
		while (node.getNext() != null) {
			System.out.println("Node Value " + node.getValue());
			Thread.sleep(500);
			node = node.getNext();
		}
	}

	public void printReverseNodesInfinite() throws InterruptedException {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		// simulating to print whole list only once
		DoubleLinkedListNode<T> node = tail.getNode();
		while (node.getPrevious() != null) {
			System.out.println("Node Value " + node.getValue());
			Thread.sleep(500);
			node = node.getPrevious();
		}
	}

	public void insert(int index, T value) {
		handleEmptyList();
		validateSizeIndex(index);
		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(value, null, null);
		if (index == 0) {
			// insertion at the front/head
			node.setNext(head.getNode());
			head.getNode().setPrevious(node);
			head.setNode(node);
			head.getNode().setPrevious(tail.getNode());
			tail.getNode().setNext(head.getNode());
			tailIndex++;
		} else {
			if (size() == index) {
				// insert at the end
				insert(value);
			} else {
				DoubleLinkedListNode<T> currnetNode = findCurrentAndPresviousNodes(index).get(0);
				DoubleLinkedListNode<T> currnetPreviousNode = findCurrentAndPresviousNodes(index).get(1);
				currnetPreviousNode.setNext(node);
				node.setPrevious(currnetPreviousNode);
				node.setNext(currnetNode);
				currnetNode.setPrevious(node);
				tailIndex++;
			}
		}
	}

	public List<DoubleLinkedListNode<T>> findCurrentAndPresviousNodes(int index) {
		handleEmptyList();
		validateIndex(index, "Can not find elment at index " + index);
		DoubleLinkedListNode<T> node = head.getNode();
		DoubleLinkedListNode<T> previousNode = null;
		for (int i = 0; i < size(); i++) {
			if (i == index) {
				break;
			}
			previousNode = node;
			node = node.getNext();
		}
		return Arrays.asList(node, previousNode);
	}

	private void validateIndex(int index, String message) {
		if (index >= size()) {
			throw new RuntimeException(message);
		}
	}

	private void validateSizeIndex(int index) {
		if (index > size()) {
			throw new RuntimeException("Can not insert at index " + index);
		}
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public int size() {
		return tailIndex;
	}

	public void printAllNodes() {
		handleEmptyList();
		DoubleLinkedListNode<T> node = head.getNode();
		for (int i = 0; i < size(); i++) {
			System.out.println("Current Node " + node.getValue());
			node = node.getNext();
		}
	}

	public void printAllNodesReverse() {
		handleEmptyList();
		DoubleLinkedListNode<T> node = tail.getNode();
		for (int i = size() - 1; i >= 0; i--) {
			System.out.println("Current Node " + node.getValue());
			node = node.getPrevious();
		}
	}

	private void handleEmptyList() {
		if (isEmpty()) {
			throw new RuntimeException("Linked List is Empty");
		}
	}

	public void remove(int index) {
		handleEmptyList();
		validateIndex(index, "Can not remove at index " + index);
		if (index == 0) {
			// deletion at the front/head
			if (head.getNode() == tail.getNode()) {
				// only one itme present
				removeList();
			} else {
				head.getNode().getNext().setPrevious(tail.getNode());
				head.setNode(head.getNode().getNext());
				tail.getNode().setNext(head.getNode());
			}
		} else {
			DoubleLinkedListNode<T> currnetNode = findCurrentAndPresviousNodes(index).get(0);
			DoubleLinkedListNode<T> currnetPreviousNode = findCurrentAndPresviousNodes(index).get(1);
			if (currnetNode == tail.getNode()) {
				// deleting at the end
				tail.setNode(currnetPreviousNode);
				currnetPreviousNode.setNext(head.getNode());
				currnetNode.setPrevious(null);
				head.getNode().setPrevious(currnetPreviousNode);
			} else {
				DoubleLinkedListNode<T> currnetNextNode = currnetNode.getNext();
				currnetPreviousNode.setNext(currnetNextNode);
				currnetNextNode.setPrevious(currnetPreviousNode);
			}

		}
		if (tailIndex != 0) {
			tailIndex--;
		}
	}

	public void removeList() {
		handleEmptyList();
		// DoubleLinkedListNode<T> node = head.getNode();
		head = tail = null;
		// removeNodeReferences(node);
		tailIndex = 0;
	}

	public int findIndex(T value) {
		handleEmptyList();
		DoubleLinkedListNode<T> node = head.getNode();
		int index = 0;
		boolean isFound = false;
		while (true) {
			if (node.getValue().equals(value)) {
				isFound = true;
				break;
			}
			if (node == tail.getNode()) {
				break;
			}
			index++;
			node = node.getNext();
		}
		if (!isFound) {
			throw new RuntimeException("Value " + value + " not found in list");
		}
		return index;
	}

}
