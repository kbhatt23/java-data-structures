package selflearning.ds;

import java.util.Arrays;
import java.util.List;

public class LinkedList {

	private HeadTailNode head;

	private HeadTailNode tail;

	public void insert(int value) {
		// first insertion -> lazy loading
		// insertion always means next node is null
		LinkedListNode newNode = new LinkedListNode(value, null);
		if (head == null || head.getType() != RootType.HEAD) {
			head = new HeadTailNode(newNode, RootType.HEAD);
		}
		// first time insertion means both head and taill will be null
		if (tail == null || tail.getType() != RootType.TAIL) {
			tail = new HeadTailNode(newNode, RootType.TAIL);
		} else {
			LinkedListNode existingLastNode = tail.getNode();
			existingLastNode.setNext(newNode);
			tail.setNode(newNode);
		}
	}

	public void printAllNodes() {
		if(head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		printNodeRecursively(head.getNode());
	}

	private void printNodeRecursively(LinkedListNode node) {
		if (node == null) {
			return;
		}
		System.out.println("node val " + node.getValue());
		printNodeRecursively(node.getNext());
	}
	
	public LinkedListNode searchNode(int value) {
		if(head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		return searchRecursively(value, head.getNode());
	}
	private LinkedListNode searchRecursively(int value, LinkedListNode node) {
		if(node == null) {
			System.out.println("item not present");
			return null;
		}
		if(node.getValue() == value) {
			System.out.println("value found");
			return node;
		}
		return searchRecursively(value, node.getNext());
	}
	//location 0 means first element
	//location -1 means last elmenet
	//location any other means that index 
	public void insertAtLocation(int value,int location) {
		if(head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNode newNode = new LinkedListNode(value, null);
		if(location == 0) {
			//insert at head
			newNode.setNext(head.getNode());
			head.setNode(newNode);
		}
		else if(location == -1) {
			//at the end as determining size will take O(n) time
			tail.getNode().setNext(newNode);
			tail.setNode(newNode);
		}else {
			LinkedListNode nodeToManipulate = findNodeAtindex(location, head.getNode(), 0 , null).get(0);
			LinkedListNode previousNode = findNodeAtindex(location, head.getNode(), 0 , null).get(1);
			previousNode.setNext(newNode);
			newNode.setNext(nodeToManipulate);
			
		}
	}
	
	public List<LinkedListNode> findNodeAtindex(int indexToFind,LinkedListNode node, int currentIndex, LinkedListNode previous) {
		if(indexToFind == currentIndex) {
			return Arrays.asList(node, previous);
		}
		return findNodeAtindex(indexToFind, node.getNext(), currentIndex+1, node);
	}
	
	public void deleteNode(int value) {
		if(head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		 deleteNodeRecursively(value, head.getNode(), null);
		
	}
	public void deleteLinkedList() {
		//enough for garbage collection
		head = tail = null;
	}
	private void deleteNodeRecursively(int value,LinkedListNode node , LinkedListNode previousNode) {
		
		if(node == null) {
			System.out.println("value not found in linked list to delete");
			return;
		}
		if(previousNode == null ) {
			System.out.println("validating value at first node");
			if(node.getValue() == value) {
				//when there is only one element in the linked list
				if(head.getNode() == tail.getNode()) {
					head= null;
					tail = null;
					return;
				}else {
				//case when first node holds value to be deleted
				System.out.println("deleting node item");
				LinkedListNode nextNode = node.getNext();
				head.setNode(nextNode);
				return;
				}
			}
			
		}
	
		if(node.getNext() == null) {
			System.out.println("validating value at first node");
			if(value == node.getValue()) {
				previousNode.setNext(null);
				tail.setNode(previousNode);
			}
		}
		System.out.println("validating value at other nodes");
		if(node.getValue() == value) {
			previousNode.setNext(node.getNext());
			return;
		}
		
		deleteNodeRecursively(value, node.getNext(), node);
		
	}
	//single linked list
	public void printNodesUsingLoop() {
		LinkedListNode node = head.getNode();
		while(node != null) {
			System.out.println("node value "+node.getValue());
			node=node.getNext();
		}
	}
}
