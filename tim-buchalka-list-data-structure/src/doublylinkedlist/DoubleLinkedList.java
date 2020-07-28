package doublylinkedlist;

import java.util.Arrays;
import java.util.List;

import common.DoubleLinkedListNode;
import common.HeadTailDoubleNode;
import common.RootType;
import util.Employee;

public class DoubleLinkedList<T> {
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
		tailIndex++;
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
		printNodesRecursively(head.getNode());
	}

	private void handleEmptyList() {
		if (isEmpty()) {
			throw new RuntimeException("Linked List is Empty");
		}
	}

	private void printNodesRecursively(DoubleLinkedListNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.println("Current Node " + node.getValue());
		printNodesRecursively(node.getNext());
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
				head.getNode().getNext().setPrevious(null);
				head.setNode(head.getNode().getNext());
			}
		} else {
			DoubleLinkedListNode<T> currnetNode = findCurrentAndPresviousNodes(index).get(0);
			DoubleLinkedListNode<T> currnetPreviousNode = findCurrentAndPresviousNodes(index).get(1);
			if (currnetNode == tail.getNode()) {
				// deleting at the end
				tail.setNode(currnetPreviousNode);
				currnetPreviousNode.setNext(null);
				currnetNode.setPrevious(null);
			} else {
				DoubleLinkedListNode<T> currnetNextNode = currnetNode.getNext();
				currnetPreviousNode.setNext(currnetNextNode);
				currnetNextNode.setPrevious(currnetPreviousNode);
			}

		}
		tailIndex--;
	}

	public void removeList() {
		handleEmptyList();
		DoubleLinkedListNode<T> node = head.getNode();
		head = tail = null;
		removeNodeReferences(node);
		tailIndex = 0;
	}

	private void removeNodeReferences(DoubleLinkedListNode<T> node) {
		if (node == null) {
			return;
		}
		node.setPrevious(null);
		removeNodeReferences(node.getNext());

	}

	public void printeReverse() {
		handleEmptyList();
		printReverseNodesRecursively(tail.getNode());
	}

	private void printReverseNodesRecursively(DoubleLinkedListNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.println("Current Node " + node.getValue());
		printReverseNodesRecursively(node.getPrevious());
	}

	public int findIndex(T value) {
		handleEmptyList();
		DoubleLinkedListNode<T> node = head.getNode();
		int index = 0;
		boolean isFound = false;
		while (node != null) {
			if (node.getValue().equals(value)) {
				isFound = true;
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

	public void addBefore(T existingValue, T value) {
		handleEmptyList();
		int index = findIndex(existingValue);
		if (index == 0) {
			insert(0, value);
		} else {
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(value, null, null);
			List<DoubleLinkedListNode<T>> findCurrentAndPresviousNodes = findCurrentAndPresviousNodes(index);
			DoubleLinkedListNode<T> currnetNode = findCurrentAndPresviousNodes.get(0);
			DoubleLinkedListNode<T> currnetPreviousNode = findCurrentAndPresviousNodes.get(1);
			currnetPreviousNode.setNext(node);
			node.setPrevious(currnetPreviousNode);
			node.setNext(currnetNode);
			currnetNode.setPrevious(node);
			tailIndex++;
		}
	}

	// assuming method will be called only for employee class
	public void insertSortedByAge(T value) {
		handleEmptyList();
		int index = findSortedIndex(value);
		if (index == 0) {
			insert(0, value);
		} else {
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(value, null, null);
			List<DoubleLinkedListNode<T>> findCurrentAndPresviousNodes = findCurrentAndPresviousNodes(index);
			DoubleLinkedListNode<T> currnetNode = findCurrentAndPresviousNodes.get(0);
			DoubleLinkedListNode<T> currnetPreviousNode = findCurrentAndPresviousNodes.get(1);
			currnetPreviousNode.setNext(node);
			node.setPrevious(currnetPreviousNode);
			node.setNext(currnetNode);
			currnetNode.setPrevious(node);
			tailIndex++;
		}
	}

	public int findSortedIndex(T value) {
		handleEmptyList();
		DoubleLinkedListNode<T> node = head.getNode();
		int index = 0;
		Employee value1 = (Employee) value;
		boolean isFound = false;
		while (node != null) {
			// if (node.getValue().equals(value)) {
			Employee value2 = (Employee) node.getValue();
			if (value1.getAge() < value2.getAge()) {
				isFound = true;
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
