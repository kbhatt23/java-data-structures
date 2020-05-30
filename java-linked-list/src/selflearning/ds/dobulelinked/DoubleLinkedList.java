package selflearning.ds.dobulelinked;

import selflearning.ds.RootType;

public class DoubleLinkedList {

	private HeadTailNodeDouble head;
	private HeadTailNodeDouble tail;

	// insert at the last position
	public void insert(int value) {
		LinkedListNodeDouble node = new LinkedListNodeDouble(value, null, null);
		if (head == null) {
			head = new HeadTailNodeDouble(node, RootType.HEAD);
		}
		if (tail == null) {
			tail = new HeadTailNodeDouble(node, RootType.TAIL);
		} else {
			LinkedListNodeDouble existingTailNode = tail.getNode();
			existingTailNode.setNext(node);
			node.setPrevious(existingTailNode);
			tail.setNode(node);
		}
	}

	public void insert(int value, int index) {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNodeDouble node = new LinkedListNodeDouble(value, null, null);
		if (index == 0) {
			LinkedListNodeDouble existingHeadNode = head.getNode();
			existingHeadNode.setPrevious(node);
			node.setNext(existingHeadNode);
			head.setNode(node);
			return;
		}
		LinkedListNodeDouble nodeFound = findNodeAtIndex(index);
		if (nodeFound == null) {
			throw new RuntimeException("no item found on that index");
		}
		node.setPrevious(nodeFound.getPrevious());
		nodeFound.getPrevious().setNext(node);
		node.setNext(nodeFound);
		nodeFound.setPrevious(node);
	}

	public LinkedListNodeDouble findNodeAtIndex(int index) {
		LinkedListNodeDouble node = head.getNode();
		int counter = 0;
		while (true) {
			if (node == null) {
				break;
			}
			if (counter == index) {
				break;
			}
			counter++;
			node = node.getNext();
		}
		return node;
	}

	public void printNodes() {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		printNodesRecursively(head.getNode());
	}

	private void printNodesRecursively(LinkedListNodeDouble node) {
		System.out.println("Node found " + node.getValue());
		// last item
		if (node == tail.getNode()) {
			return;
		}

		printNodesRecursively(node.getNext());
	}

	public void printNodesUsingLoop() {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNodeDouble node = head.getNode();
		while (true) {
			System.out.println("using loop Node found " + node.getValue());
			if (node == tail.getNode()) {
				return;
			}
			node = node.getNext();
		}
	}

	public void deleteNode(int value) {
		deleteNodeRecursively(value, head.getNode());
	}

	public LinkedListNodeDouble searchNode(int value) {
		LinkedListNodeDouble node = head.getNode();
		while (true) {
			if (node.getValue() == value) {
				return node;
			}
			if(node == tail.getNode()) {
				break;
			}
			node = node.getNext();
		}
		System.out.println("node is not found");
		return null;
	}

	public void printReverse() {
		if (head == null) {
			throw new RuntimeException("Linked list is empty");
		}
		printReverseRecursively(tail.getNode());
	}

	public void printReverseUsingLoop() {
		LinkedListNodeDouble node = tail.getNode();
		while (true) {
			System.out.println("rever node found " + node.getValue());
			if (node == head.getNode()) {
				break;
			}
			node = node.getPrevious();
		}
	}

	private void printReverseRecursively(LinkedListNodeDouble node) {
		if (node == null) {
			// whole traversing done
			return;
		}
		System.out.println("reverse node found " + node.getValue());
		printReverseRecursively(node.getPrevious());
	}

	private void deleteNodeRecursively(int value, LinkedListNodeDouble node) {
		if (node == null) {
			System.out.println("item not found to be deleted");
			return;
		}
		if (node.getValue() == value) {
			// first elment
			if (head.getNode() == node) {
				if (head.getNode() == tail.getNode()) {
					// only one lement present
					head = tail = null;
				} else {
					// more than one element present
					head.setNode(node.getNext());
					// need to allow GC
					node.getNext().setPrevious(null);
				}
			} else {
				if (node == tail.getNode()) {
					node.getPrevious().setNext(node.getNext());
					tail.setNode(node.getPrevious());
				} else {
					// any other than last
					node.getPrevious().setNext(node.getNext());
					node.getNext().setPrevious(node.getPrevious());
					node.setPrevious(null);
					node.setNext(null);
				}
			}
			// no need to dlete other
			return;
		}
		deleteNodeRecursively(value, node.getNext());
	}

	public void deleteNodeAtIndex(int index) {
		LinkedListNodeDouble nodeFound = findNodeAtIndex(index);
		if (nodeFound == head.getNode()) {
			if (head.getNode() == tail.getNode()) {
				// only one lement present
				head = tail = null;
			} else {
				// more than one element present
				head.setNode(nodeFound.getNext());
				// need to allow GC
				nodeFound.getNext().setPrevious(null);
			}
		} else {
			if (nodeFound == tail.getNode()) {
				nodeFound.getPrevious().setNext(nodeFound.getNext());
				tail.setNode(nodeFound.getPrevious());
			} else {
				// any other than last
				nodeFound.getPrevious().setNext(nodeFound.getNext());
				nodeFound.getNext().setPrevious(nodeFound.getPrevious());
				nodeFound.setPrevious(null);
				nodeFound.setNext(null);
			}
		}
	}
	
	public void removeLinkedList() {
		LinkedListNodeDouble node = head.getNode();
		head = null;
		tail =null;
		removeLinkedListRecursively(node);
	}

	private void removeLinkedListRecursively(LinkedListNodeDouble node) {
		if(node == null || node.getNext() == null) {
			return;
		}
		node.getNext().setPrevious(null);
		removeLinkedListRecursively(node.getNext());
	}
}
