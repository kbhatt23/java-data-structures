package selflearning.ds.circulardobulelinked;

import java.util.function.UnaryOperator;

import selflearning.ds.RootType;
import selflearning.ds.dobulelinked.HeadTailNodeDouble;
import selflearning.ds.dobulelinked.LinkedListNodeDouble;

public class CircularDoubleLinkedList {

	private HeadTailNodeDouble head;

	private HeadTailNodeDouble tail;

	public void insert(int value) {
		LinkedListNodeDouble node = new LinkedListNodeDouble(value, null, null);
		if (head == null && tail == null) {
			// first time only, when linkedlist was empty
			// circular
			node.setNext(node);
			node.setPrevious(node);
			head = new HeadTailNodeDouble(node, RootType.HEAD);
			tail = new HeadTailNodeDouble(node, RootType.TAIL);
		} else {
			LinkedListNodeDouble currentLAstNode = tail.getNode();
			currentLAstNode.setNext(node);
			node.setPrevious(currentLAstNode);
			head.getNode().setPrevious(node);
			node.setNext(head.getNode());
			tail.setNode(node);
		}
	}

	public void insert(int index, int value) {
		//this can be used only when atleast one item is present in linked list
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNodeDouble node = new LinkedListNodeDouble(value, null, null);
		if (index == 0) {
			LinkedListNodeDouble currentHeadNode = head.getNode();
			head.setNode(node);
			node.setPrevious(tail.getNode());
			node.setNext(currentHeadNode);
			currentHeadNode.setPrevious(node);
			tail.getNode().setNext(node);
		} else {
			LinkedListNodeDouble currentNode = findNodeAtIndex(index);
			if (currentNode == head.getNode()) {
				LinkedListNodeDouble currentHeadNode = head.getNode();
				head.setNode(node);
				node.setPrevious(tail.getNode());
				node.setNext(currentHeadNode);
				currentHeadNode.setPrevious(node);
				tail.getNode().setNext(node);
			} else {
				node.setNext(currentNode);
				node.setPrevious(currentNode.getPrevious());
				currentNode.getPrevious().setNext(node);
				currentNode.setPrevious(node);
			}
		}
	}

	public LinkedListNodeDouble findNodeAtIndex(int index) {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNodeDouble node = head.getNode();
		int count = 0;
		while (true) {
			if (count == index) {
				return node;
			}
			node = node.getNext();
			count++;
		}
	}

	public void printNodesInfinitely() {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNodeDouble node = head.getNode();
		printLoop(node, LinkedListNodeDouble::getNext);
	}

	public void printReverseNodesInfinitely() {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNodeDouble node = tail.getNode();
		printLoop(node, LinkedListNodeDouble::getPrevious);
	}
	
	public void printNodesOnce() {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNodeDouble node = head.getNode();
		int headNodeCount=0;
		while(true) {
			if(head.getNode() == node) {
				headNodeCount++;
			}
			if(headNodeCount == 2) {
				return;
			}
			System.out.println("node value found "+node.getValue());
			
			node = node.getNext();
		}
	}
	
	public LinkedListNodeDouble findNode(int value) {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNodeDouble node = head.getNode();
		while(true) {
			if(node.getValue() == value) {
				return node;
			}
			if(node.getNext() == head.getNode()) {
				break;
			}
			node= node.getNext();
				
		}
		System.out.println("Item not found");
		return null;
	}
	public void printReverseNodesOnce() {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNodeDouble node = tail.getNode();
		int tailNodeCount=0;
		while(true) {
			if(tail.getNode() == node) {
				tailNodeCount++;
			}
			if(tailNodeCount == 2) {
				return;
			}
			System.out.println("node value found "+node.getValue());
			
			node = node.getPrevious();
		}
	}

	private void printLoop(LinkedListNodeDouble node, UnaryOperator<LinkedListNodeDouble> operator) {
		while (true) {
			System.out.println("node value found " + node.getValue());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			node = operator.apply(node);
		}
	}

	public void deleteNode(int value) {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNodeDouble node = head.getNode();

		int headNodeCount = 0;
		deleteNodeRecursively(headNodeCount, node, value);
	}

	private void deleteNodeRecursively(int headNodeCount, LinkedListNodeDouble node, int value) {
		if (headNodeCount == 2) {
			System.out.println("item can not be found to delete");
			return;
		}
		if (node == head.getNode()) {
			headNodeCount++;
		}
		if (node.getValue() == value) {
			// value found
			if (node == head.getNode()) {
				// case when only one item exist
				if (head.getNode() == tail.getNode()) {
					head = tail = null;
					// for GC
					node.setNext(null);
					node.setPrevious(null);
				} else {
					// when there are more than one items
					LinkedListNodeDouble currentNext = node.getNext();
					head.setNode(currentNext);
					currentNext.setPrevious(tail.getNode());
					tail.getNode().setNext(currentNext);
				}
			} else if (tail.getNode() == node) {
				LinkedListNodeDouble currentPrevious = node.getPrevious();
				tail.setNode(currentPrevious);
				head.getNode().setPrevious(currentPrevious);
				currentPrevious.setNext(head.getNode());
			} else {
				// items exist anywhere in between
				LinkedListNodeDouble currentPrevious = node.getPrevious();
				LinkedListNodeDouble currentNext = node.getNext();
				currentPrevious.setNext(currentNext);
				currentNext.setPrevious(currentPrevious);
			}
			return;
		}
		deleteNodeRecursively(headNodeCount, node.getNext(), value);
	}
	
	public void removeLinkedList() {
		if (head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNodeDouble headNode = head.getNode();
		LinkedListNodeDouble tailNode = tail.getNode();
		head= tail =null;
		headNode.setPrevious(null);
		tailNode.setNext(null);
		
		while(true) {
			if(headNode.getNext() == null) {
				break;
				}
			headNode.getNext().setPrevious(null);
			headNode = headNode.getNext();
		}
	}
}
