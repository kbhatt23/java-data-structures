package selflearning.ds;

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
}
