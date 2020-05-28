package selflearning.ds.circular.sibglelinkedlist;

import java.util.Arrays;
import java.util.List;

import selflearning.ds.HeadTailNode;
import selflearning.ds.LinkedListNode;
import selflearning.ds.RootType;

public class CirclularSingleLinkedList {

	private HeadTailNode head;
	private HeadTailNode tail;
	//method that adds value at the end only
	public void insert(int value) {
		LinkedListNode node = new LinkedListNode(value, null);
		if (head == null) {
			head = new HeadTailNode(node, RootType.HEAD);
		}
		if (tail == null) {
			tail = new HeadTailNode(node, RootType.TAIL);
		} else {
			LinkedListNode currentLastNode = tail.getNode();
			currentLastNode.setNext(node);
			tail.setNode(node);
		}
		// cyclic node
		// first entry will have next as itself as this is circular list
		//any other case also last entry will always point to head node
		node.setNext(head.getNode());
	}
	//user can insert node at specifc index
	public void insert(int value, int index) {
		List<LinkedListNode> findPReviousAndCurrent = findPReviousAndCurrent(index);
		LinkedListNode previousNode = findPReviousAndCurrent.get(0);
		LinkedListNode existingNode = findPReviousAndCurrent.get(1);
		LinkedListNode newNode= new LinkedListNode(value, existingNode);
		previousNode.setNext(newNode);
	}
	
	public LinkedListNode findNodeAtIndex(int searchIndex) {
		if(head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNode node= head.getNode();
		int index=0;
		while(true) {
			if(index == searchIndex) {
				System.out.println("lets break it");
				return node;
			}
			index++;
			node= node.getNext();
		}
	}
	
	public LinkedListNode searchNode(int value) {
		return searchNodeRecursively(value, head.getNode());
	}
	//countFirstNode is used to break the loop as last elements next item is first so loop goes on
	private LinkedListNode searchNodeRecursively(int value, LinkedListNode node) {

		if(node.getValue() == value) {
			return node;
		}
		if(node.getNext() == head.getNode()) {
			System.out.println("item not found");
			return null;
		}
		return searchNodeRecursively(value, node.getNext());
	}
	public List<LinkedListNode> findPReviousAndCurrent(int searchIndex) {
		if(head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		LinkedListNode node= head.getNode();
		LinkedListNode previous = null;
		int index=0;
		while(true) {
			if(index == searchIndex) {
				break;
			}
			index++;
			previous=node;
			node= node.getNext();
		}
		return Arrays.asList(previous,node);
	}
	public void printNodesInfinite() throws InterruptedException {
		if(head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		//simulating to print whole list only once
		LinkedListNode node = head.getNode();
		while(node.getNext() != null) {
			System.out.println("Node Value "+node.getValue());
			Thread.sleep(500);
			node=node.getNext();
		}
	}
	
	public void printNodesOnce() {
		if(head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		//simulating to print whole list only once
		printNodeRecursively(head.getNode() , 0);
	}
	private void printNodeRecursively(LinkedListNode nodeToPrint , int firstNodeCount) {
		if(firstNodeCount == 1) {
			return;
		}
		System.out.println("Node value "+nodeToPrint.getValue());
		//last elemnt points to first elment linked to head
		if(nodeToPrint.getNext().equals(head.getNode()))
			firstNodeCount++;
		printNodeRecursively(nodeToPrint.getNext(), firstNodeCount);
	}
	
	public void deleteNode(int value) {
		if(head == null) {
			throw new RuntimeException("data is not yet inserted");
		}
		deleteNodeRecursively(value, head.getNode(), null);
	}
	private void deleteNodeRecursively(int value, LinkedListNode node, LinkedListNode previousNode) {
		//first value of iteration
		if(previousNode == null) {
			if(value == node.getValue()) {
				if(head.getNode() == tail.getNode()) {
					//only one item present
					//otherwise wont be able for garbage collection
					node.setNext(null);
					head= tail =null;
				}else {
					head.setNode(node.getNext());
					tail.getNode().setNext(node.getNext());
				}
				return;
			}
		}
		//getting head node element for second time
		if(previousNode != null && node == head.getNode()) {
			System.out.println("item not found");
			return;
		}
		//last node
		if(head.getNode() == node.getNext()) {
			if(node.getValue()==value) {
			previousNode.setNext(head.getNode());
			tail.setNode(previousNode);
			return;
			}
		}
		if(node.getValue() == value) {
			previousNode.setNext(node.getNext());
			return;
		}
		deleteNodeRecursively(value, node.getNext(), node);
	}
	public void deleteLinkedList() {
		//need this to remove circular dependency
		tail.getNode().setNext(null);
		head = tail = null;
		
	}
}
