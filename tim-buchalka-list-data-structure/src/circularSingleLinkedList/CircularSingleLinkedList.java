package circularSingleLinkedList;

import java.util.Arrays;
import java.util.List;

import common.HeadTailSingleNode;
import common.RootType;
import common.SingleLinkedListNode;

public class CircularSingleLinkedList<T> {
	private HeadTailSingleNode<T> head;
	private HeadTailSingleNode<T> tail;

	// lazy loading and hence not creating head until value is given
	// by default we are assuming to add at the end
	// inserting at the head will be O(1) constant time but this approach will be
	// linear O(n)
	public void insert(T value) {
		SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(value, null);
		// if first item is getting added
		if (head == null) {
			head = new HeadTailSingleNode<T>(RootType.HEAD, node);
			tail = new HeadTailSingleNode<T>(RootType.TAIL, node);
		} else {
			// some item exists
			tail.getNode().setNext(node);
			tail.setNode(node);
		}
		node.setNext(head.getNode());
	}

	public void insert(int index, T value) {
		handleEmptyList();
		validateSizeIndex(index);
		SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(value, null);
		if (index == 0) {
			// insertion at the front/head
			node.setNext(head.getNode());
			head.setNode(node);
			tail.getNode().setNext(node);
		} else {
			if (size() == index) {
				// insert at the end
				insert(value);
			} else {
				SingleLinkedListNode<T> currnetNode = findCurrentAndPresviousNodes(index).get(0);
				SingleLinkedListNode<T> currnetPreviousNode = findCurrentAndPresviousNodes(index).get(1);
				currnetPreviousNode.setNext(node);
				node.setNext(currnetNode);
			}
		}

	}

	public List<SingleLinkedListNode<T>> findCurrentAndPresviousNodes(int index) {
		handleEmptyList();
		validateIndex(index, "Can not find elment at index " + index);
		SingleLinkedListNode<T> node = head.getNode();
		SingleLinkedListNode<T> previousNode = null;
		for (int i = 0; i < size(); i++) {
			if (i == index) {
				break;
			}
			previousNode = node;
			node = node.getNext();
		}
		return Arrays.asList(node, previousNode);
	}

	private void validateSizeIndex(int index) {
		if (index > size()) {
			throw new RuntimeException("Can not insert at index " + index);
		}
	}

	public void printAllNodes() {
		handleEmptyList();
		printNodesRecursively(head.getNode());
	}

	private void handleEmptyList() {
		if (head == null) {
			throw new RuntimeException("Linked List is Empty");
		}
	}

	private void printNodesRecursively(SingleLinkedListNode<T> node) {
		System.out.println("Current Node " + node.getValue());
		if (node == tail.getNode()) {
			return;
		}
		printNodesRecursively(node.getNext());
	}

	public int size() {
		int size = 0;
		if (head != null) {
			SingleLinkedListNode<T> headNode = head.getNode();
			while (true) {
				size++;
				if (headNode == tail.getNode()) {
					break;
				}
				headNode = headNode.getNext();

			}
		}
		return size;
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
				head.setNode(head.getNode().getNext());
				tail.getNode().setNext(head.getNode());
			}
		} else {
			SingleLinkedListNode<T> currnetNode = findCurrentAndPresviousNodes(index).get(0);
			SingleLinkedListNode<T> currnetPreviousNode = findCurrentAndPresviousNodes(index).get(1);
			if (currnetNode == tail.getNode()) {
				// deleting at the end
				tail.setNode(currnetPreviousNode);
				currnetPreviousNode.setNext(head.getNode());
			} else {
				SingleLinkedListNode<T> currnetNextNode = currnetNode.getNext();
				currnetPreviousNode.setNext(currnetNextNode);
			}

		}

	}

	private void validateIndex(int index, String message) {
		if (index >= size()) {
			throw new RuntimeException(message);
		}
	}

	public int findIndex(T value) {
		handleEmptyList();
		SingleLinkedListNode<T> node = head.getNode();
		int index = 0;
		boolean isFound = false;
		while (true) {
			if (node.getValue().equals(value)) {
				isFound = true;
				break;
			}
			if(node == tail.getNode()) {
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

	public void removeList() {
		List<SingleLinkedListNode<T>> findCurrentAndPresviousNodes = findCurrentAndPresviousNodes(size()-1);
		findCurrentAndPresviousNodes.get(0).setNext(null);
		head= tail=null;
	}

	// do not have get previous and hence can not used tail.get node method
	public void printeReverse() {
		handleEmptyList();
		printReverseRecurisively(head.getNode());
	}

	private void printReverseRecurisively(SingleLinkedListNode<T> node) {
		if(node == tail.getNode()) {
			System.out.println("Printing node "+node.getValue());
		}else {
			printReverseRecurisively(node.getNext());
			System.out.println("Printing node "+node.getValue());
		}

	}

	public void printNodesInfinite() throws InterruptedException {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		// simulating to print whole list only once
		SingleLinkedListNode<T> node = head.getNode();
		while (node.getNext() != null) {
			System.out.println("Node Value " + node.getValue());
			Thread.sleep(500);
			node = node.getNext();
		}
	}
	
	public boolean isEmpty() {
		return head==null;
	}

}
