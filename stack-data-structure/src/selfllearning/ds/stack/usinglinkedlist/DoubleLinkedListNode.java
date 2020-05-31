package selfllearning.ds.stack.usinglinkedlist;

public class DoubleLinkedListNode {

	private int value;

	private DoubleLinkedListNode next;

	private DoubleLinkedListNode previous;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public DoubleLinkedListNode getNext() {
		return next;
	}

	public void setNext(DoubleLinkedListNode next) {
		this.next = next;
	}

	public DoubleLinkedListNode getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleLinkedListNode previous) {
		this.previous = previous;
	}

	public DoubleLinkedListNode(int value, DoubleLinkedListNode next, DoubleLinkedListNode previous) {
		this.value = value;
		this.next = next;
		this.previous = previous;
	}

}
